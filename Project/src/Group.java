import java.util.*;

public class Group {
    String groupName;
    public static HashMap<String, Group> sampleGroups  = new HashMap();
    HashMap<String, Member> members = new HashMap<>();
    ArrayList<Song> allSongs = new ArrayList<>();

    public Group(String group){

        groupName = group;

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public void addTimes(Song currSong, String info, boolean initSet){
        String memName = info.substring(0, info.indexOf(":"));
        Integer distTime = Integer.parseInt(info.substring(info.indexOf(":") + 1, info.lastIndexOf(":") ));
        String role = info.substring(info.lastIndexOf(":") + 1);
        Member newMember = null;
        if(initSet){
            newMember = new Member(memName);
            members.put(memName, newMember);
            members.get(memName).setPosition(role);
        }

        ArrayList<Integer> data = new ArrayList<>(2);
        data.add(distTime);
//        System.out.println(memName + ": " + " \n Total Singing Time: " + distTime + "\n Position: " + role);
        currSong.memberTimes.put(newMember, data);
        members.get(memName).getSongTimes().put(currSong, data);

        currSong.addTime(distTime);                        //Increment total song time
    }

    public static Group addGroup(String name){
        Group addedGroup = new Group(name);
        sampleGroups.put(name, addedGroup);
        return addedGroup;
    }
}
