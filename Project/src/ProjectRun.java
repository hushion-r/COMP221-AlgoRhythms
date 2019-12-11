import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProjectRun {
    public static void main(String args []) {
        System.out.println("we have not failed yet");
        processFile("soup.txt");

    }

    public static void processFile(String txtFile) {
        InputStream in = new ByteArrayInputStream(txtFile.getBytes());

        Scanner scan = new Scanner(in).useDelimiter(".\\s*");
        while(scan.hasNext()){
            Group currGroup;
            boolean init = false;

            String groupName = scan.next();                                 //Make new group if we haven't encountered them
            if(!Group.sampleGroups.containsKey(groupName)){
                init = true;
               currGroup = Group.addGroup(groupName);
               System.out.println(groupName);
            }
            else{
                currGroup = Group.sampleGroups.get(groupName);              //else get the group object from someplace else
            }

            Song newSong = new Song(scan.next(), currGroup);                //makes new song object
            currGroup.addTimes(newSong, scan.next(), init);
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
