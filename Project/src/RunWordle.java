//import comp124graphics.CanvasWindow;
//
//import java.awt.*;
//import java.io.File;
//
///**
// * Created by bjackson.
// */
//public class RunWordle {
//
//    private CanvasWindow canvas;
//
//    public static void main(String[] args){
//        RunWordle wordle = new RunWordle();
//        wordle.run();
//    }
//
//    public RunWordle(){
//        canvas = new CanvasWindow("Wordle", 1600, 800);
//    }
//
//    public void run() {
//        File f1 = new File("124-word-counter/dat/trump.txt");
//        File f2 = new File("124-word-counter/dat/hillary.txt");
//
//        DistinctiveWordFinder finder = new DistinctiveWordFinder();
//        finder.countWords(f1, f2);
//        WordScore[] scores = finder.findDistinctive();
//
//        Wordle wordle = new Wordle(scores, Color.RED, canvas.getWidth()/4.0, canvas.getHeight()/2.0);
//        canvas.add(wordle);
//        wordle.doLayout();
//
//        finder = new DistinctiveWordFinder();
//        finder.countWords(f2, f1);
//        scores = finder.findDistinctive();
//
//        Wordle wordle2 = new Wordle(scores, Color.BLUE, canvas.getWidth()/4.0*3, canvas.getHeight()/2.0);
//        canvas.add(wordle2);
//        wordle2.doLayout();
//    }
//}
