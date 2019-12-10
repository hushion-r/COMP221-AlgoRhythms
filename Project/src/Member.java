import java.util.HashMap;
import java.util.LinkedList;

public class Member {
    String memberName;
    String position;
    HashMap<Song, LinkedList<Integer>> songTimes = new HashMap<>();    // Song: [seconds, percentage]

    public Member(String nme){
        memberName = nme;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public HashMap<Song, LinkedList<Integer>> getSongTimes() {
        return songTimes;
    }

    public void setSongTimes(HashMap<Song, LinkedList<Integer>> songTimes) {
        this.songTimes = songTimes;
    }
}
