package club.banyuan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ListUnitTest {

  @Test
  public void test() {
    List<Integer> list = new ArrayList<>();

    list.add(12);
    list.add(15);
    printList(list);

    Assert.assertEquals(list.size(), 2);
    Assert.assertEquals(list.get(0).intValue(), 12);
    Assert.assertEquals(list.remove(1), Integer.valueOf(15));
    Assert.assertTrue(list.remove(Integer.valueOf(12)));

    Assert.assertEquals(list.size(), 0);
    Assert.assertTrue(list.isEmpty());
    list.add(22);
    list.add(33);
    list.add(44);
    Assert.assertEquals(list.size(), 3);
    Assert.assertEquals(list.set(2, 55), Integer.valueOf(44));
    list.clear();
    Assert.assertEquals(list.size(), 0);
  }

  public static List<? extends Number> printList(List<?> list) {
    Iterator<?> iterator = list.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println("[" + count + "]=" + iterator.next());
      count++;
    }
    return new ArrayList<>();
  }
  // public static void printList(List<Integer> list) {
  //   Iterator<Integer> iterator = list.iterator();
  //   int count = 0;
  //   while (iterator.hasNext()) {
  //     System.out.println("[" + count + "]=" + iterator.next());
  //     count++;
  //   }
  // }
}
