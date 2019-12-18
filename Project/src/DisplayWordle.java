import javax.swing.*;
import java.awt.*;


// Run class

/*
 * HOW TO USE:
 * 1) Run this file
 * 2) In the top selector, click on 1 song from GOT7 and 1 song from BTS
 * 3) Click "Compare Go!" button
 * 4) Wait a few seconds for it to update
*/
public class DisplayWordle extends JFrame {

    private Group default1;     // The two groups to compare
    private Group default2;
    private CreateWordle createWordle;

    public DisplayWordle(String text) {

        this.setContentPane(new JPanel(){
            @Override
            public void paintComponent(Graphics image){
                super.paintComponent(image);
            }
        });

        default1 = Group.allGroups.get("GOT7");
        default2 = Group.allGroups.get("BTS");

        new JFrame(text).setTitle(text);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1700, 800);
        createBanner();

        createWordle = new CreateWordle();
        add(createWordle.getCanvas());
        this.pack();
        this.setVisible(true);
        createWordle.run(Group.allGroups);
    }

    public static void main(String args[]){
        CreateWordle.processFile("input.txt");

        new DisplayWordle("Kpop Line Distribution Go!");
    }

    public void createBanner(){
        JPanel bothGroups = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bothGroups.setBackground(Color.WHITE);
        bothGroups.setSize(850, 20);

        JPanel firstGroup = new JPanel();
        JLabel firstName = new JLabel(default1.groupName);
        firstGroup.add(firstName);
        //Song list for the first group
        JList<Song> songList1 = new JList(default1.allSongs.toArray());
        firstGroup.add(songList1);
        bothGroups.add(firstGroup);

        //Repeat for second group
        JPanel secondGroup = new JPanel();
        JLabel secondName = new JLabel(default2.groupName);
        secondGroup.add(secondName);
        JList<Song> songList2 = new JList(default2.allSongs.toArray());
        songList2.setAutoscrolls(true);
        secondGroup.add(songList2);
        bothGroups.add(secondGroup);

        JButton compare = new JButton("Compare Go!");
        compare.addActionListener(e -> {    // To update song shown to the newly selected song
            Song song1 = songList1.getSelectedValue();
            Song song2 = songList2.getSelectedValue();
            createWordle.updateWordle(song1);
            createWordle.updateWordle(song2);
        });
        bothGroups.add(compare);
        add(bothGroups);
    }
}
