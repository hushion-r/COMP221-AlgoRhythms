import comp124graphics.CanvasWindow;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by bjackson.
 */
public class CreateWordle {

    private CanvasWindow canvas;
    private HashMap<Group, Wordle> wordles = new HashMap<>();
    private double y;


    public CreateWordle() {
        canvas = new CanvasWindow("Wordle", 1600, 800);
        y = canvas.getHeight();
    }

    public void run(HashMap<String, Group> groups) {
        double d = canvas.getWidth()/4.0;
        for (Group currGroup : groups.values()) {
            Wordle wordle = new Wordle(currGroup, currGroup.allSongs.get(0), (canvas.getWidth()/2.0) + d, y);
            wordles.put(currGroup, wordle);
            canvas.add(wordle);
            wordle.doLayout();
            d = -d;
        }
        canvas.pause(1000);
    }

    public void updateWordle(Song song) {
        Wordle wordle = wordles.get(song.group);
        wordle.removeAll();
        wordle.updateWordle2(song);
        wordle.doLayout();
    }

    public static void processFile(String txt){
        processFile(ProjectRun.class.getResourceAsStream("/" + txt));
    }

    public static void processFile(InputStream in) {
        Scanner scan = new Scanner(in).useDelimiter(";");
        String currLine = scan.next().trim();
        currLine = currLine.replaceAll("\r\n", "");
        System.out.println(currLine);
        while(scan.hasNext() && !currLine.equals("\r\n.")) {
            Scanner sc = new Scanner(currLine.replaceAll("\r\n", "")).useDelimiter(", ");
            Group currGroup;
            boolean init = false;

            String groupName = sc.next();                                 //Make new group if we haven't encountered them
            if (!Group.allGroups.containsKey(groupName)) {
                init = true;
                currGroup = Group.addGroup(groupName);
            }
            else {
                currGroup = Group.allGroups.get(groupName);              //else get the group object from someplace else
            }

            Song currSong = new Song(sc.next().trim(), currGroup);//makes new song object
            currGroup.allSongs.add(currSong);
            while (sc.hasNext()) {
                currGroup.addTimes(currSong, sc.next().trim(), init);
            }
            currSong.calcPercentages();
            sc.close();
            currLine = scan.next();
        }
        scan.close();
    }

    public CanvasWindow getCanvas() {
        return canvas;
    }
}
