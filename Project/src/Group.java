import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Group {
    String groupName;
    List<Member> members = new ArrayList<>();

    public Group(String group){

        groupName = group;

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public static TreeSet<Group> sampleGroups  = new TreeSet<>();

    public void addMember(String name){
        Member newMemb = new Member(name);
        members.add(newMemb);
    }

    public int findMember(String name){
        boolean found = false;
        int i = 0;
        while(!found){
            if(getMembers().get(i).getName().equals(name)){
                found = true;
                return i;
            }
            else{
                i++;
            }
        }

        return -1;
    }
}
