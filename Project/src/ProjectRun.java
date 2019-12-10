import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProjectRun {
    public static void main(String args []) {
        System.out.println("we have not failed yet");
        //processFile();

    }

//    public static void processFile(InputStream txtFile) {
//
//        Scanner scan = new Scanner(txtFile);
//        while(scan.hasNext()){
//            boolean isNewGroup = false;
//
//            String groupName = scan.next();                     //If we haven't encountered the group, make a new object and add the members
//            if(!Group.sampleGroups.containsKey(groupName)){
//                isNewGroup = true;
//               Group.addGroup(groupName.substring(0,1), groupName);
//               System.out.println(groupName);                              //A Test
//            }
//            else{
//                //newGroup = Group.sampleGroups.get(groupName);           //else get the group object from someplace else
//            }
//
//            String songName = scan.next();                      //makes new song object
//            Song newSong = new Song(songName, newGroup);
//
//            String[] data = scan.next().split(":");       //Get member and the total song time;
//            System.out.print(data[0] + " " + data[1]);
//
//            if(isNewGroup){
//                newGroup.addMember(data[0]);
//            }
//
//            int index = newGroup.findMember(data[0]);       //might need to be refined, currently does a brute force search\
//
//            LinkedList<Integer> numbers = new LinkedList<>();
//            numbers.add(Integer.valueOf(data[1]));
//
//            newGroup.getMembers().get(index).getSongTimes().put(newSong, numbers);
//
//        }
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
//        */
//
////        File soup = new File("Soup.txt");
//////        soup.createNewFile();
//////        Scanner scanner = new Scanner(soup);
////
////
//////        FileReader reader = new FileReader(soup);
//////
//////        while (scanner.hasNextLine()) {
////
//////        }
//
////        assignPercentages();
//
//    }


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
