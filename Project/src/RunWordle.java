import comp124graphics.CanvasWindow;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by bjackson.
 */
public class RunWordle {

    private CanvasWindow canvas;
    private HashMap<Group, Wordle> wordles = new HashMap<>();
    private double y;


    public RunWordle() {
        canvas = new CanvasWindow("Wordle", 1600, 800);
        y = canvas.getHeight() / 2.0;
    }

    public void run(HashMap<String, Group> groups) {
        double d = 1.5;
        for (Group currGroup : groups.values()) {
            Wordle wordle = new Wordle(currGroup, currGroup.allSongs.get(0), canvas.getWidth() / d, y);
            wordles.put(currGroup, wordle);
            canvas.add(wordle);
            wordle.doLayout();
            d += d;
        }
        canvas.pause(1000);
        updateWordle(groups.get("BTS"), groups.get("BTS").allSongs.get(1));
//            wordle.removeAll();

//        Wordle wordle = new Wordle(groups.get("BTS").members, groups.get("BTS").allSongs.get(1), Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
//        canvas.add(wordle);
//        wordle.doLayout();
    }

    public void updateWordle(Group group, Song song) {
        Wordle wordle = wordles.get(group);
        wordle.removeAll();
        wordle.updateWordle(group,song);
        wordle.doLayout();
    }
}
