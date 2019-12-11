import java.util.*;

public class Group {
    String groupName;
    ArrayList<Member> members = new ArrayList<>();

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

//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }

    public static HashMap<String, LinkedList<Group>> sampleGroups  = new HashMap();

    public void addMember(String name){
        Member newMemb = new Member(name);
        members.add(newMemb);
    }

    public int findMember(String name){             //Can probably be refined
        boolean found = false;
        int i = 0;
        while(!found){
            if(getMembers().get(i).getMemberName().equals(name)){
                found = true;
                return i;
            }
            else{
                i++;
            }
        }

        return -1;
    }

    public static Group addGroup(String firstLet, String grp){
        Group addedGroup = new Group(grp);
        if(sampleGroups.containsKey(firstLet)){
            sampleGroups.get(firstLet).add(addedGroup);
        }
        else{
            LinkedList<Group> groups = new LinkedList<Group>();
            groups.add(addedGroup);
            sampleGroups.put(firstLet, groups);
        }
        return addedGroup;
    }

    public static Group findGroup(String name){
           LinkedList<Group> searchArea = sampleGroups.get(name.substring(0,1));
           boolean found = false;   int i =0;
           while(!found){
               if(searchArea.get(i).getGroupName().equals(name)){
                   found = true;
                   return searchArea.get(i);
               }
               i++;
           }
           return(addGroup(name.substring(0,1), name));
    }
}
