import comp124graphics.CanvasWindow;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by bjackson.
 */
public class RunWordle {

    private CanvasWindow canvas;
    private Song[] songsToCompare = new Song[10];


    public RunWordle() {
        canvas = new CanvasWindow("Wordle", 1600, 800);
    }

    public void run(HashMap<String, Group> groups) {
        for (Group currGroup : groups.values()) {
            Wordle wordle = new Wordle(currGroup.members, currGroup.allSongs.get(0), Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
            canvas.add(wordle);
            wordle.doLayout();

            wordle.pause(200);
            wordle.removeAll();
        }

//        Wordle wordle = new Wordle(groups.get("BTS").members, groups.get("BTS").allSongs.get(1), Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
//        canvas.add(wordle);
//        wordle.doLayout();
    }
}
