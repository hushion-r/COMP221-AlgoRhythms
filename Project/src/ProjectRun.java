import javax.swing.*;
import java.io.*;
import java.util.*;
///fnisfbidnbjk
public class ProjectRun {
    public static void main(String args [])  {
        processFile("Soup.txt");
        RunWordle wordle = new RunWordle(new JFrame());
        wordle.run(Group.sampleGroups);
//        wordle.run(Group.sampleGroups.get("BTS").members, Group.sampleGroups.get("BTS").allSongs.get(0));
    }

    static void processFile(String txt){
        processFile(ProjectRun.class.getResourceAsStream("/" + txt));
    }

    static void processFile(InputStream in) {
        Scanner scan = new Scanner(in).useDelimiter(";");
        String currLine = scan.next().trim();
        currLine = currLine.replaceAll("\r\n", "");
        System.out.println(currLine);
        while(scan.hasNext() && !currLine.equals("\r\n.")) {
            Scanner sc = new Scanner(currLine.replaceAll("\r\n", "")).useDelimiter(", ");
            Group currGroup;
            boolean init = false;

            String groupName = sc.next();                                 //Make new group if we haven't encountered them
            if (!Group.sampleGroups.containsKey(groupName)) {
                init = true;
                currGroup = Group.addGroup(groupName);
            }
            else {
                currGroup = Group.sampleGroups.get(groupName);              //else get the group object from someplace else
            }

            Song currSong = new Song(sc.next().trim(), currGroup);//makes new song object
            currGroup.allSongs.add(currSong);
            while (sc.hasNext()) {
                currGroup.addTimes(currSong, sc.next().trim(), init);
            }
            currSong.assignPercentages();
            sc.close();
            currLine = scan.next();
        }
        scan.close();
    }
}
