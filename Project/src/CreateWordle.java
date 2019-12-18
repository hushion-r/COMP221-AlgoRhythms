import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsText;

import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Created originally by bjackson.
 */
public class CreateWordle {

    private CanvasWindow canvas;
    private HashMap<Group, Wordle> wordles = new HashMap<>();
    private double y;

    public CreateWordle() {
        canvas = new CanvasWindow("Wordle", 1600, 800);
        y = canvas.getHeight();

        legend();
    }

    /*
    * Iterates over the groups and creates a Wordle object for each, using the song data for the first song of the group as a default.
     */
    public void run(HashMap<String, Group> groups) {
        double d = canvas.getWidth()/4.0;
        for (Group currGroup : groups.values()) {
            Wordle wordle = new Wordle(currGroup, currGroup.allSongs.get(0), (canvas.getWidth()/2.0) + d, y);
            wordles.put(currGroup, wordle);
            canvas.add(wordle);
            wordle.doLayout();
            d = -d;
        }
    }

    /*
    * Gets the Wordle for a certain group, removes the GraphicsObjects from the Wordle GraphicsGroup.
    * Updates the members' names sizes and positions based on the Song selected.
     */
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
        while(scan.hasNext() && !currLine.equals("\r\n.")) {
            Scanner sc = new Scanner(currLine.replaceAll("\r\n", "")).useDelimiter(", ");
            Group currGroup;
            boolean init = false;

            String groupName = sc.next();
            if (!Group.allGroups.containsKey(groupName)) {   // Make new Group if we haven't encountered them
                init = true;
                currGroup = Group.addGroup(groupName);
            }
            else {
                currGroup = Group.allGroups.get(groupName); // Else get the Group object
            }

            Song currSong = new Song(sc.next().trim(), currGroup);  // Make new Song object
            currGroup.allSongs.add(currSong);
            while (sc.hasNext()) {
                currGroup.addTimes(currSong, sc.next().trim(), init);   // Add second amounts
            }
            currSong.calcPercentages();     // Calculate percentage of song sung by each member
            sc.close();
            currLine = scan.next();
        }
        scan.close();
    }

    public void legend() {
        String legend = "Legend:";
        GraphicsText legendGText = new GraphicsText(legend, (float) 800.0, (float) 100.0);
        canvas.add(legendGText);
        legend = "Rapper - RED";
        legendGText =  new GraphicsText(legend, (float) 800.0, (float) 130.0);
        legendGText.setStrokeColor(Color.RED);
        canvas.add(legendGText);
        legend = "Vocalist - GREEN";
        legendGText =  new GraphicsText(legend, (float) 800.0, (float) 160.0);
        legendGText.setStrokeColor(Color.GREEN);
        canvas.add(legendGText);
    }

    public CanvasWindow getCanvas() {
        return canvas;
    }
}
