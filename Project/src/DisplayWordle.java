import comp124graphics.Image;

import javax.swing.*;
import java.awt.*;

public class DisplayWordle extends JFrame {

    private Group default1;
    private Group default2;

    public DisplayWordle(String title) {
        ProjectRun.processFile("soup.txt");

        default1 = Group.sampleGroups.get("GOT7");
        default2 = Group.sampleGroups.get("BTS");

        System.out.println(Group.sampleGroups.toString());

        System.out.print("Group I'm trying to include" + default1.groupName);
        System.out.print("Second Group I'm trying to include" + default2.groupName);


        new JFrame(title);
        createBanner();
        pack();
        setVisible(true);
//        addGroup(default1);
//        addGroup(default2);
    }

    public static void main(String args[]){
        new DisplayWordle("Test");
    }

    public void createBanner(){
        JPanel bothGroups = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        JPanel firstGroup = new JPanel();
        JLabel firstName = new JLabel(default1.groupName);

        firstGroup.add(firstName);
        //Song list for the first group
        JList songList1 = new JList(default1.allSongs.toArray());
        firstGroup.add(songList1);
        bothGroups.add(firstGroup);

        JPanel secondGroup = new JPanel();
        JLabel secondName = new JLabel(default2.groupName);
        secondGroup.add(secondName);
        //list of songs for second group
        JList songList2 = new JList(default2.allSongs.toArray());
        secondGroup.add(songList2);
        bothGroups.add(secondGroup);

        add(bothGroups);
    }

//    public void updateGroup(Group grp){
//       // BoxLayout group1Box = new BoxLayout(this, width);
//        JPanel newGroup = new JPanel();
//
//        //Label Name of Group
//        JLabel groupName = new JLabel(grp.groupName, Label.LEFT);
//        newGroup.add(groupName);
//
//        JList allSongs = new JList(grp.allSongs.toArray());
//        newGroup.add(allSongs);
//
//
//
//        add(newGroup);
//
//    }


}
