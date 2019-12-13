import java.util.*;

public class Member {
    String memberName;
    String position;
    HashMap<Song, ArrayList<Integer>> songTimes = new HashMap<>();    // Song: [seconds, percentage]

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

    public Integer getSongPercent(Song song) {
        return songTimes.get(song).get(1);
    }

    public void setSongPercent(Song song, int percentage) {
        songTimes.get(song).add(1, percentage);
    }
}
