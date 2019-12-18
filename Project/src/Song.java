import java.util.ArrayList;
import java.util.HashMap;

public class Song {
    public Group group;
    public String songName;
    public Integer totalTimeDist;  // Sum of line distributions
    public HashMap<Member, ArrayList<Integer>> memberTimes = new HashMap<>();    // Member: [seconds, percentage]

    public Song(String songName, Group group){
        this.songName = songName;
        this.group = group;
        totalTimeDist = 0;
    }

    public void calcTotalTimeDistr(int seconds){
        totalTimeDist += seconds;
    }

    public void calcPercentages() {
        double percentage;
        for (Member member : this.memberTimes.keySet()) {
            percentage = ((double) this.memberTimes.get(member).get(0) / totalTimeDist) * 100.0;

            this.memberTimes.get(member).add((int) percentage); // set percentage in Song object

            member.setSongPercent(this, (int) percentage); // set percentage in Member object
        }
    }

    @Override
    public String toString(){
        return this.songName;
    }

}
