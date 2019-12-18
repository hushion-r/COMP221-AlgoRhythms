import comp124graphics.CanvasWindow;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by bjackson.
 */
public class RunWordle {

    private CanvasWindow canvas;
    private HashMap<Group, Wordle> wordles = new HashMap<>();


    public RunWordle() {
        canvas = new CanvasWindow("Wordle", 1600, 800);
    }

    public void run(HashMap<String, Group> groups) {
        double d = 1.5;
        for (Group currGroup : groups.values()) {
            Wordle wordle = new Wordle(currGroup.members, currGroup.allSongs.get(0), Color.RED, Color.GREEN, canvas.getWidth() / d, canvas.getHeight() / 2.0);
            wordles.put(currGroup, wordle);
            canvas.add(wordle);
            wordle.doLayout();
            d += d;
        }
        canvas.pause(1000);
//            wordle.removeAll();

//        Wordle wordle = new Wordle(groups.get("BTS").members, groups.get("BTS").allSongs.get(1), Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
//        canvas.add(wordle);
//        wordle.doLayout();
    }

    public void updateWordle(Group group, Song song) {
        Wordle wordle = wordles.get(group);
        double x = wordle.getX();
        double y = wordle.getY();
        wordle.removeAll();

//        Wordle wordle = new Wordle(currGroup.members, currGroup.allSongs.get(0), Color.RED, Color.GREEN, canvas.getWidth() / d, canvas.getHeight() / 2.0);
//        wordles.put(currGroup, wordle);
//        canvas.add(wordle);
//        wordle.doLayout();
    }
}
