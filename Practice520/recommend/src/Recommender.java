import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Recommender {

    void addLikes(String name,String Object);
    boolean likesBoth(String name,String Object1,String Object);
    List<String> recommendByPerson(String name);
    List<String> recommendByProject(String Object);

}
