import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.nio.file.Paths;

public class ProjectRun {
    public static void main(String args []) throws IOException {
        System.out.println("we have not failed yet");
        processFile("Soup.txt");

    }

    static void processFile(String txt){
        processFile(ProjectRun.class.getResourceAsStream("/" + txt));
    }

    static void processFile(InputStream in) {

        Scanner scan = new Scanner(in).useDelimiter("\n");

        while(scan.hasNextLine()){
            String song1 = scan.next();
            Scanner sc = new Scanner(song1).useDelimiter(",");
            Group currGroup;
            boolean init = false;

            String groupName = sc.next();                                 //Make new group if we haven't encountered them
            if(!Group.sampleGroups.containsKey(groupName)){
                init = true;
               currGroup = Group.addGroup(groupName);
               //System.out.println(groupName);
            }
            else{
                currGroup = Group.sampleGroups.get(groupName);              //else get the group object from someplace else
            }

            Song newSong = new Song(sc.next(), currGroup);                //makes new song object
            while(scan.hasNext()){
                currGroup.addTimes(newSong, sc.next(), init);
            }
        }
//
//
//                /* READ UNTIL "."
//            Read all until ","
//            1st time - groupName
//                does group exist already?
//            2nd - songName
//                create Song object
//            After - create members
//                IF group doesn't exits
//                IF group exists, add info to Member.songsAndTimes
//
////        assignPercentages();
//
    }

    public void assignPercentages(Song song, Integer total) {
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
