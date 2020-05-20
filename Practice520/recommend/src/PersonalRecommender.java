import java.util.*;

public class PersonalRecommender implements Recommender {
    private HashMap<String, LinkedList<String>> Likes = new HashMap<>();

    @Override
    public void addLikes(String name, String Obj) {
        if(Likes.get(name).isEmpty()){
            LinkedList<String> Node = new LinkedList<>();
            Likes.put(name,Node);
        }else{
            Likes.get(name).add(Obj);
        }


    }

    @Override
    public boolean likesBoth(String name, String Object1, String Object) {
        try {
            if (Likes.get(name) != null) {
                return Likes.get(name).contains(Object1) && Likes.get(name).contains(Object);
            }
            else
                throw new UnknownPersonException("系统中找不到这个人");
        } catch (UnknownPersonException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String> recommendByPerson(String name) {
        return Likes.get(name);
    }

    @Override
    public List<String> recommendByProject(String Object) {
        List<String> output = new LinkedList<>();
        for (String name : Likes.keySet()) {
            if (Likes.get(name).contains(Object))
                output.add(Object);
        }
        return output;
    }


}
