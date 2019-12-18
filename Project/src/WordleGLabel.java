import comp124graphics.GraphicsText;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by bjackson on 10/12/2015.
 */
public class WordleGLabel extends GraphicsText {

    public static final int SMALLEST_FONT_SIZE = 10;
    public static final int BIGGEST_FONT_SIZE = 100;

    private Member member = null;
    private Shape wordShape = null;


    /**
     * Construct a WordleGLable
     * @param member
     * @param highScore largest possible score
     * @param lowScore smallest possible score
     */
    public WordleGLabel(Member member, Song song, double highScore, double lowScore){
        super(member.memberName, 0 , 0);
        this.member = member;
        // Determine the font size given the score value
        int fontSize = (int)(((member.getSongPercent(song)-lowScore)/(highScore-lowScore)*(BIGGEST_FONT_SIZE-SMALLEST_FONT_SIZE))+SMALLEST_FONT_SIZE);
        Font font = new Font("default", Font.PLAIN, fontSize);
        setFont(font);
        initializeShape();
    }

    /**
     * Initializes the shape used to test for intersections with other labels
     */
    private void initializeShape(){
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = Graphics2D.class.cast(img.getGraphics());
        FontRenderContext frc = g.getFontRenderContext();
        TextLayout textLayout = new TextLayout(member.memberName, getFont(), frc);
        wordShape = textLayout.getOutline(null);
        Rectangle2D bounds = wordShape.getBounds2D();
        double wordCenterX = bounds.getCenterX();
        double wordCenterY = bounds.getCenterY();
        setPosition(-wordCenterX,-wordCenterY); // center the word
        g.dispose();
    }

    /**
     * Get shape
     * @return
     */
    public Shape getShape() {
        return wordShape;
    }

    /**
     * Updates the shape based on moving the position of the label
     * @param dx delta x
     * @param dy delta y
     */
    private void updateShape(double dx, double dy){
        AffineTransform moveTo = AffineTransform.getTranslateInstance(dx, dy);
        wordShape = moveTo.createTransformedShape(wordShape);
    }

    /**
     * Override of the move method so we can also update the shape
     * @param dx
     * @param dy
     */
    @Override
    public void move(double dx, double dy){
        super.move(dx, dy);
        updateShape(dx, dy);
    }

    /**
     * Override of the setLocation method so we can also update the shape.
     * @param x
     * @param y
     */
    @Override
    public void setPosition(double x, double y){
        double dx = x - getX();
        double dy = y - getY();
        super.setPosition(x, y);
        updateShape(dx, dy);
    }

    /**
     * Test for intersection with another wordle label.
     * @param other
     * @return true if there is an intersection between this and other.
     */
    public boolean intersects(WordleGLabel other){
        Area area = new Area(wordShape);
        Area otherArea = new Area(other.getShape());
        area.intersect(otherArea);
        return !area.isEmpty();
    }
}
