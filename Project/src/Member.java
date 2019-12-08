import java.util.HashMap;
import java.util.LinkedList;

public class Member {
    String name;
    String position;
    HashMap<Song, LinkedList> songTimes = new HashMap<>();    // Song: [seconds, percentage]

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public HashMap<Song, LinkedList> getSongTimes() {
        return songTimes;
    }

    public void setSongTimes(HashMap<Song, LinkedList> songTimes) {
        this.songTimes = songTimes;
    }
}
