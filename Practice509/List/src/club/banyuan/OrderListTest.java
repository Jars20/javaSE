package club.banyuan;

import club.banyuan.collection.ArrayList;
import club.banyuan.collection.List;
import club.banyuan.util.Comparable;
import club.banyuan.util.Iterator;

public class OrderListTest {

  public static void main(String[] args) {
    List list = new ArrayList();
    list.add(new Elephant(120));
    list.add(new Elephant(100));
    list.add(new Elephant(180));
    list.add(new Elephant(140));
    list.add(new Elephant(130));
    list.add(new Elephant(150));
    list.add(new Elephant(170));
    list.add(new Elephant(160));
    printList(list);
    sortList(list);
    printList(list);
  }

  public static void printList(List list) {
    Iterator iterator = list.iterator();
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println("[" + count + "]=" + iterator.next());
      count++;
    }
  }

  public static void sortList(List list) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        if (((Comparable) list.get(j)).compareTo((Comparable) list.get(i)) > 0) {
          Object temp = list.get(j);
          list.set(j, list.get(i));
          list.set(i, temp);
        }
      }
    }
  }
}
