import javax.swing.*;
import java.awt.*;

public class DisplayWordle extends JFrame {



    private Group default1;
    private Group default2;

    public DisplayWordle(String text) {

        Image background = Toolkit.getDefaultToolkit().getImage("kpop.jpg");

        this.setContentPane(new JPanel(){
            @Override
            public void paintComponent(Graphics image){
                super.paintComponent(image);
                image.drawImage(background, 0, 0, this);
            }
        });

        default1 = Group.allGroups.get("GOT7");
        default2 = Group.allGroups.get("BTS");

        new JFrame(text).setTitle(text);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1700, 800);
        createBanner();

        this.pack();
        this.setVisible(true);

        CreateWordle wordle = new CreateWordle();
        wordle.run(Group.allGroups);
    }

    public static void main(String args[]){
        CreateWordle.processFile("soup.txt");

        new DisplayWordle("Kpop Line Distribution Go!");
        System.out.println(Group.allGroups.toString());
    }

    public void createBanner(){
        JPanel bothGroups = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bothGroups.setBackground(Color.WHITE);
        bothGroups.setSize(1000, 10);

        JPanel firstGroup = new JPanel();
        JLabel firstName = new JLabel(default1.groupName);
        firstGroup.setSize(300, 10);
        firstGroup.setBackground(Color.WHITE);
        firstGroup.add(firstName);
        //Song list for the first group
        JList songList1 = new JList(default1.getSongNames());
        firstGroup.add(songList1);
        bothGroups.add(firstGroup);

        //Repeat for second group
        JPanel secondGroup = new JPanel();
        secondGroup.setBackground(Color.white);
        secondGroup.setSize(300, 10);
        
        JLabel secondName = new JLabel(default2.groupName);
        secondGroup.add(secondName);
        //list of songs for second group
        JList songList2 = new JList(default2.getSongNames());
        secondGroup.add(songList2);
        bothGroups.add(secondGroup);

        JButton compare = new JButton("Compare Go!");
        compare.addActionListener(e -> {
           Song song1 = (Song) songList1.getSelectedValue();
           Song song2 = (Song)songList2.getSelectedValue();

       });
        bothGroups.add(compare);
        add(bothGroups);
    }

}
