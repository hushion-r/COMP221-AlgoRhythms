import java.util.*;

public class Group {
    public static HashMap<String, Group> allGroups = new HashMap();

    String groupName;
    HashMap<String, Member> members = new HashMap<>();
    ArrayList<Song> allSongs = new ArrayList<>();

    public Group(String group){

        groupName = group;

    }

    public void addTimes(Song currSong, String info, boolean initSet){
        String memName = info.substring(0, info.indexOf(":"));
        Integer distTime = Integer.parseInt(info.substring(info.indexOf(":") + 1, info.lastIndexOf(":") ));
        String role = info.substring(info.lastIndexOf(":") + 1);
        Member currMember = null;
        if(initSet){
            currMember = new Member(memName);
            members.put(memName, currMember);
            members.get(memName).setPosition(role);
        }
        currMember = members.get(memName);
        ArrayList<Integer> data = new ArrayList<>(2);
        data.add(distTime);
        currSong.memberTimes.put(currMember, data);
        currSong.calcTotalTimeDistr(distTime);                        //Increment total song time
        members.get(memName).songTimes.put(currSong, data);
    }

    public static Group addGroup(String name){
        Group addedGroup = new Group(name);
        allGroups.put(name, addedGroup);
        return addedGroup;
    }

    public String[] getSongNames () {
        String[] songNames = new String[20];

        int i = 0;
        for (Song song : allSongs) {
            songNames[i] = song.songName;
            i++;
        }

        return songNames;
    }
}
