import comp124graphics.CanvasWindow;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by bjackson.
 */
public class RunWordle {

    private CanvasWindow canvas;
    private Song[] songsToCompare = new Song[10];


    public RunWordle() {
        canvas = new CanvasWindow("Wordle", 1600, 800);
    }

    public void run(HashMap<String, Member> members, Song song) {

        Wordle wordle = new Wordle(members, song, Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
//        Wordle wordle = new Wordle(members, songsToCompare[0], Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
        canvas.add(wordle);
        wordle.doLayout();

//        for(Group currGroup: Group.sampleGroups.values()){
//            Wordle wordle = new Wordle(currGroup, songsToCompare[0], Color.RED, Color.GREEN, canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
//        }

    }
}
