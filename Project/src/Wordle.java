import comp124graphics.GraphicsGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;

/**
 * Created by bjackson on 10/12/2015.
 */
public class Wordle extends GraphicsGroup {

    public static final int MAX_WORDS = 30;
    private WordleGLabel[] labels;
    private Random rgen;
    private double highScore = 100.0;
    private double lowScore = 1.0;
    public Song song;

    // go through songs in one group
//    public Wordle(HashMap<String, Member> members, Song song, double x, double y) {
    public Wordle(Group group, Song song, double x, double y) {
        super(x,y);
        this.song = song;
        rgen = new Random();

        int maxIndex = Math.min(group.members.size(), MAX_WORDS - 1);
        labels = new WordleGLabel[maxIndex];

        int i = 0;
        for (Member mem : group.members.values()) {
            labels[i] = new WordleGLabel(mem, song, highScore, lowScore);
            if (mem.position.equals("rapper")) {
                labels[i].setStrokeColor(Color.RED);
            } else if (mem.position.equals("vocalist")) {
                labels[i].setStrokeColor(Color.GREEN);
            }
            if (i<group.members.size()-1) i++;
        }
    }

    public void updateWordle(Group group, Song song) {
        int i = 0;
        for (Member mem : group.members.values()) {
            labels[i] = new WordleGLabel(mem, song, highScore, lowScore);
            if (mem.position.equals("rapper")) {
                labels[i].setStrokeColor(Color.RED);
            } else if (mem.position.equals("vocalist")) {
                labels[i].setStrokeColor(Color.GREEN);
            }
            if (i<group.members.size()-1) i++;
        }

    }


    /**
     * Positions each WordleGLabel according to the wordle algorithm.
     */
    public void doLayout() {
        Point.Double center = new Point2D.Double(0.0, 0.0);
        for(int i=0; i < labels.length; i++){
            Point2D.Double initialPosition = makeInitialPosition(center);
            double xPos = initialPosition.x;
            double yPos = initialPosition.y;
            labels[i].setPosition(xPos, yPos);

            final double DELTA_ANGLE = Math.random() < 0.5 ? 1 : -1;
            double angle = DELTA_ANGLE;

            while (checkIntersections(labels[i])) {
                updatePosition(labels[i],initialPosition,angle);
                angle = angle + .25;
            }

            add(labels[i]);

            pause(100);
        }
    }

    /**
     * Returns a random point within a gaussian distribution centered on center.
     * Used to set the initial position of a word.
     * @param center of the distribution
     * @return random gaussian point.
     */
    private Point.Double makeInitialPosition(Point.Double center){
        final double STDDEV = 25;
        double x = rgen.nextGaussian()* STDDEV + center.getX();
        double y = rgen.nextGaussian() * STDDEV + center.getY();
        return  new Point.Double(x, y);
    }

    /**
     * Updates the position of a label using a spiral pattern centered on initialPos.
     * @param label to position
     * @param initialPos for label, used as the center of the spiral
     * @param angle current angle around the spiral
     */
    private void updatePosition(WordleGLabel label, Point.Double initialPos, double angle){
        double x = initialPos.getX() + angle * Math.cos(angle);
        double y = initialPos.getY() + angle * Math.sin(angle);
        label.setPosition(x, y);
    }

    /**
     * Checks for intersections between the label and all other WordleGLabels that are already added to the canvas
     * @param label
     * @return true if an intersection is found.
     */
    private boolean checkIntersections(WordleGLabel label){
        Iterator it = this.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            if (obj instanceof WordleGLabel) {
                WordleGLabel other = (WordleGLabel) obj;
                if (label != other && label.intersects(other)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Pauses the program for milliseconds
     * @param milliseconds
     */
    public void pause(long milliseconds){
        try{
            Thread.sleep(milliseconds);
        }
        catch(InterruptedException e) {
            // Empty
        }
    }
}
