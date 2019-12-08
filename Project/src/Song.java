import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;

public class Song {
    Group group;     // stores Member objects, which store name, position, songs and times
    String songName;
    Integer totalTimeDist;  // sum of line distributions
    HashMap<Member, LinkedList<Integer>> memberTimes = new HashMap<>();    // Member: [seconds, percentage]

    public Song(String song, Group gp){
        songName = song;
        group = gp;
    }

    public void addTime(int time){
        totalTimeDist += time;
    }
}
