import java.util.*;

public class PersonalRecommender implements Recommender {

  private Map<String, Set<String>> Likes = new HashMap<>();

  @Override
  public void addLikes(String name, String Obj) {
    if (!Likes.containsKey(name)) {
      Set<String> personLikes = new HashSet<>();
      personLikes.add(Obj);
      Likes.put(name, personLikes);
    } else {
      Likes.get(name).add(Obj);
    }


  }

  @Override
  public boolean likesBoth(String name, String project1, String project2) {
      if (Likes.get(name) != null) {
          return Likes.get(name).contains(project1) && Likes.get(name).contains(project2);
//        Set<String> projects = likes.get(person);
//        return projects.containsAll(Set.of(project1, project2));
      } else {
          throw new UnknownPersonException("系统中找不到这个人");
      }
  }

  @Override
  public List<String> recommendByPerson(String name) {
      if (Likes.containsKey(name)) {
          return new ArrayList<>(Likes.get(name));
      } else {
          throw new UnknownPersonException("系统中找不到这个人");
      }
  }

  @Override
  public List<String> recommendByProject(String Object) {
    Set<String> output = new HashSet<>();

    for (String name : Likes.keySet()) {
        if (Likes.get(name).contains(Object)) {
            output.addAll(Likes.get(name));
        }
    }
    output.remove(Object);
    return new ArrayList<>(output);
  }


}
