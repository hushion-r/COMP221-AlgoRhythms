import javax.swing.*;
import java.awt.*;

public class DisplayWordle extends JFrame {

    private Group default1;
    private Group default2;

    public DisplayWordle(String text) {
        ProjectRun.processFile("soup.txt");

        default1 = Group.sampleGroups.get("GOT7");
        default2 = Group.sampleGroups.get("BTS");

        System.out.println(Group.sampleGroups.toString());

//        System.out.print("Group I'm trying to include" + default1.groupName);
//        System.out.print("Second Group I'm trying to include" + default2.groupName);


        new JFrame(text);

        this.setSize(1700, 900);
        setUpBackground();
        createBanner();

        pack();
        setVisible(true);

    }

    public static void main(String args[]){
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
        JList songList1 = new JList(default1.allSongs.toArray());
        firstGroup.add(songList1);
        bothGroups.add(firstGroup);

        //Repeat for second group
        JPanel secondGroup = new JPanel();
        JLabel secondName = new JLabel(default2.groupName);
        secondGroup.add(secondName);
        //list of songs for second group
        JList songList2 = new JList(default2.allSongs.toArray());
        secondGroup.add(songList2);
        bothGroups.add(secondGroup);

        JButton compare = new JButton("Compare Go!");
        compare.addActionListener(e -> {
           String song1 = songList1.getSelectedValue().toString();
           String song2 = songList2.getSelectedValue().toString();
           updateWordle(song1, song2);
       });

        add(compare);
        add(bothGroups);
    }

    /**
     * Credits to @Samual Sam from Tutorials Point for how to include a background image
     */
    public void setUpBackground(){
        Image background = Toolkit.getDefaultToolkit().getImage("kpop.jpg");
        this.setContentPane(new JPanel(){
                @Override
                public void paintComponent(Graphics image){
                    super.paintComponent(image);
                    image.drawImage(background, 0, 0, null);
                }
        });
    }

    public void updateWordle(String song1, String song2 ){
        // needs to update wordle and return two wordle things
//           add(new Wordle(song1, song2))


    }

}
