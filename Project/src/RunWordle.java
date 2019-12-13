import comp124graphics.CanvasWindow;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by bjackson.
 */
public class RunWordle {

    private CanvasWindow canvas;
    private Song[] songsToCompare = new Song[10];

    public static void main(String[] args) {
        RunWordle wordle = new RunWordle();
        wordle.run();
    }

    public RunWordle() {
        canvas = new CanvasWindow("Wordle", 1600, 800);
    }

    public void run() {
        ////
        Group group1 = new Group("BTS");
        HashMap<String, Member> memberssss = new HashMap<>();
        Song song1 = new Song("Run", group1);


        Member member1 = new Member("Jimin");
        member1.position = "vocalist";
        Member member2 = new Member("J-Hope");
        member2.position = "rapper";
        Member member3 = new Member("Jungkook");
        member3.position = "vocalist";
        Member member4 = new Member("Jin");
        member4.position = "vocalist";

        memberssss.put(member1.memberName, member1);
        memberssss.put(member2.memberName, member2);
        memberssss.put(member3.memberName, member3);
        memberssss.put(member4.memberName, member4);

        group1.members = memberssss;

        HashMap<Song, ArrayList<Integer>> songTimes = new HashMap<>();
        ArrayList<Integer> listy = new ArrayList<>();
        listy.add(60);  // seconds
        listy.add(30);  // percentage
        songTimes.put(song1, listy);
        member1.songTimes = songTimes;

        songTimes = new HashMap<>();
        listy = new ArrayList<>();
        listy.add(40);  // seconds
        listy.add(20);  // percentage
        songTimes.put(song1, listy);
        member2.songTimes = songTimes;

        songTimes = new HashMap<>();
        listy = new ArrayList<>();
        listy.add(80);  // seconds
        listy.add(40);  // percentage
        songTimes.put(song1, listy);
        member3.songTimes = songTimes;

        songTimes = new HashMap<>();
        listy = new ArrayList<>();
        listy.add(20);  // seconds
        listy.add(10);  // percentage
        songTimes.put(song1, listy);
        member4.songTimes = songTimes;
        ////

        songsToCompare[0] = song1;

        HashMap<String, Member> members = songsToCompare[0].group.members;

        Wordle wordle = new Wordle(members, songsToCompare[0], Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
        canvas.add(wordle);
        wordle.doLayout();
    }
}
