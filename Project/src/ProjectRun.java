import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class ProjectRun {
    public static void main(String args []) {
        System.out.println("we have not failed yet");


    }

    public void processFile(String txtFile) throws IOException {
        /* READ UNTIL "."
            Read all until ","
            1st time - groupName
                does group exist already?
            2nd - songName
                create Song object
            After - create members
                IF group doesn't exits
                IF group exists, add info to Member.songsAndTimes
        */

//        File soup = new File("Soup.txt");
////        soup.createNewFile();
////        Scanner scanner = new Scanner(soup);
//
//
////        FileReader reader = new FileReader(soup);
////
////        while (scanner.hasNextLine()) {
//
////        }

//        assignPercentages();



    }


    public void assignPercentages(Song song) {
        Integer totalLineDistr;
        for (Member member : song.memberTimes.keySet()) {

            Integer percent = song.memberTimes.get(member).get(0);
        }
    }
}
