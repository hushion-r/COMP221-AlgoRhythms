import java.util.ArrayList;
import java.util.HashMap;

public class Song {
    Group group;     // stores Member objects, which store memberName, position, songs and times
    String songName;
    Integer totalTimeDist;  // sum of line distributions
    HashMap<Member, ArrayList<Integer>> memberTimes = new HashMap<>();    // Member: [seconds, percentage]

    public Song(String song, Group gp){
        songName = song;
        group = gp;
        totalTimeDist = 0;
    }

    public void addTime(int time){
        totalTimeDist += time;
    }

    public void assignPercentages() {
        double percentage;
        for (Member member : this.memberTimes.keySet()) {
            percentage = ((double) this.memberTimes.get(member).get(0) / totalTimeDist) * 100.0;

            this.memberTimes.get(member).add((int) percentage);
            // set percentage in Song object

            System.out.print(member);
            member.setSongPercent(this, (int) percentage);
            // set percentage in Member object
        }
    }


}
