package club.banyuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListTest {

  public static void main(String[] args) {
    // List list = new LinkedList();

    // System.out.println(new Integer(5) == new Integer(5));

    List<Integer> list = new ArrayList<>();

    // list.add(new Elephant(200));
    // list.add(new Elephant(300));
    // list.remove(new Elephant(300));
    // System.out.println(list.size());
    // list.add(12);
    // list.add(15);

    list.add(12);
    list.add(15);
    printList(list);

    System.out.println(list.size() == 2);
    System.out.println(list.get(0) == 12);
    System.out.println(list.remove(1) == 15);
    System.out.println(list.remove(Integer.valueOf(12)));

    System.out.println(list.size() == 0);
    System.out.println(list.isEmpty());
    list.add(22);
    list.add(33);
    list.add(44);
    System.out.println(list.size() == 3);
    System.out.println((Integer) list.set(2, 55) == 44);
    list.clear();
    System.out.println(list.size() == 0);

    // list.add(1);
    // System.out.println(list.remove(0));

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    printList(list);

    list.remove(2);
    list.remove(0);
    printList(list);

    List<String> stringList = new ArrayList<>();

    printList(stringList);
    // Integer = int
    // Long = long
    List<Number> numberList = new ArrayList<>();
    // numberList.add(12);
    numberList.add(12.12F);

    List<?> list1 = printList(numberList);
    Object o = list1.get(0);
    List<Integer> list11 = (List<Integer>) list1;
    Number number = list11.get(0);
    System.out.println(number);

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
