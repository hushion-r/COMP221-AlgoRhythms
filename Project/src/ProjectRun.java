import java.io.*;
import java.util.*;

public class ProjectRun {
    public static void main(String args [])  {
        processFile("Soup.txt");


    }

    static void processFile(String txt){
        processFile(ProjectRun.class.getResourceAsStream("/" + txt));
    }

    static void processFile(InputStream in) {

        Scanner scan = new Scanner(in).useDelimiter(";");
        String currLine = scan.next();
        while(scan.hasNext()) {
            Scanner sc = new Scanner(currLine).useDelimiter(",");
            Group currGroup;
            boolean init = false;

            String groupName = sc.next();                                 //Make new group if we haven't encountered them
            if (!Group.sampleGroups.containsKey(groupName)) {
                init = true;
                currGroup = Group.addGroup(groupName);
                System.out.println(groupName);
            } else {
                currGroup = Group.sampleGroups.get(groupName);              //else get the group object from someplace else
            }

            Song currSong = new Song(sc.next(), currGroup);//makes new song object
            currGroup.allSongs.add(currSong);
            System.out.println(currSong.songName);
            while (sc.hasNext()) {
                currGroup.addTimes(currSong, sc.next(), init);
            }
            assignPercentages(currSong, currSong.totalTimeDist);
            sc.close();
            currLine = scan.next();
        }
        scan.close();
    }

    public static void assignPercentages(Song song, Integer total) {
        Integer percentage = 0;
        for (Member member : song.memberTimes.keySet()) {
            percentage = song.memberTimes.get(member).get(0) / total * 100;

            song.memberTimes.get(member).set(1, percentage);
            // set percentage in Song object
            member.songTimes.get(song).set(1, percentage);
            // set percentage in Member object
        }
    }

}
