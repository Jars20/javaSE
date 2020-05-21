package club.banyuan;

import club.banyuan.animal.Animal;
import club.banyuan.animal.Tiger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import org.junit.Test;

public class Main {

  public static void main(String[] args) {
    List<Elephant> list = new ArrayList<>();
    list.add(new Elephant(1234));
    list.add(new Elephant(5555));
    list.add(new Elephant(3333));
    list.add(new Elephant(2222));
    list.add(new Elephant(4444));

    printElephant(list);
    System.out.println("after sort");
    Collections.sort(list);

    printElephant(list);

  }

  private static void printElephant(List<?> list) {
    for (Object elephant : list) {
      System.out.println(elephant);
    }
  }

  @Test
  public void compatitorDemo() {
    List<ElephantNotComparable> list = new ArrayList<>();
    list.add(new ElephantNotComparable(1234));
    list.add(new ElephantNotComparable(5555));
    list.add(new ElephantNotComparable(3333));
    list.add(new ElephantNotComparable(2222));
    list.add(new ElephantNotComparable(4444));
    printElephant(list);
    sort(list, Comparator.comparingInt(ElephantNotComparable::getHeight));
    printElephant(list);
  }


  public static <T> void sort(List<T> target, Comparator<T> comparator) {
    for (int i = 0; i < target.size(); i++) {
      for (int j = i + 1; j < target.size(); j++) {
        if (comparator.compare(target.get(i), target.get(j)) > 0) {
          T temp = target.get(i);
          target.set(i, target.get(j));
          target.set(j, temp);
        }
      }
    }
  }

  @Test
  public void callMethod() {
    // (o1,o2) -> o1.xxx - o2.xxx;

    // int applyAsInt(T value);
    ToIntFunction<Elephant> toIntFunction = value -> value.getHeight();

    toIntFunction.applyAsInt(new Elephant(12345));

    Tiger tiger = new Tiger(300);

    GetHeight<Tiger> getTigerHeight = test -> test.tigerHeightWithParam(test.getHeightInCM());
    // target.getHeightInCM();

    System.out.println(getTigerHeight.getHeightVal(tiger));
  }
}
