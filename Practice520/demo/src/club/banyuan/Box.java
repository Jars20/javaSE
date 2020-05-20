package club.banyuan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T> implements Iterable<T> {

  private List<T> something = new ArrayList<>();

  public void add(T t) {
    something.add(t);
  }

  @Override
  public Iterator<T> iterator() {
    return something.iterator();
  }


  public static void main(String[] args) {
    int[] p = new int[2];

    Box<Long> box = new Box<>();

    box.add(123L);
    // box.add("123");
    // box.add("123");
    // box.add("123");

    for (Long s : box) {

    }
  }
}
