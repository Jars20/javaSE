package club.banyuan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();

    set.add(3);
    set.add(5);
    set.add(1);
    set.add(-9);
    set.add(10);

    for (Integer integer : set) {
      System.out.println(integer);
    }

    Iterator<Integer> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("+++++++++++");
    // TreeSet 会对保存的元素进行排序，元素必须要实现Comparable接口
    Set<Integer> treeSet = new TreeSet<>();
    treeSet.add(3);
    treeSet.add(5);
    treeSet.add(1);
    treeSet.add(-9);
    treeSet.add(10);
    for (Integer integer : treeSet) {
      System.out.println(integer);
    }

    Set<Elephant> elephants = new TreeSet<>();
    elephants.add(new Elephant(123));
    elephants.add(new Elephant(333));
    elephants.add(new Elephant(99));
    elephants.add(new Elephant(222));
    for (Elephant elephant : elephants) {
      System.out.println(elephant);
    }

    // linkedHashSet会保留元素的插入顺序
    Set<Integer> linkedSet = new LinkedHashSet<>();
    linkedSet.add(3);
    linkedSet.add(5);
    linkedSet.add(1);
    linkedSet.add(-9);
    linkedSet.add(10);
    linkedSet.add(5); // 插入重复的数据，会忽略到本次插入
    printSet(linkedSet);

    // set保留的对象不会出现重复，重复的判断标准是根据equals和hashcode进行判断
    Set<Elephant> uniqueElephant = new TreeSet<>();
    uniqueElephant.add(new Elephant(123));
    uniqueElephant.add(new Elephant(333));
    uniqueElephant.add(new Elephant(333));
    uniqueElephant.add(new Elephant(333));
    uniqueElephant.add(new Elephant(99));
    uniqueElephant.add(new Elephant(222));
    uniqueElephant.add(new Elephant(222));
    printSet(uniqueElephant);

    System.out.println("删除重复的大象对象");
    List<Elephant> duplicateElephantList = new ArrayList<>();
    duplicateElephantList.add(new Elephant(123));
    duplicateElephantList.add(new Elephant(333));
    duplicateElephantList.add(new Elephant(333));
    duplicateElephantList.add(new Elephant(333));
    duplicateElephantList.add(new Elephant(99));
    duplicateElephantList.add(new Elephant(222));
    duplicateElephantList.add(new Elephant(222));
    for (Elephant elephant : removeDuplicate(duplicateElephantList)) {
      System.out.println(elephant);
    }
  }

  public static void printSet(Set<?> target) {
    for (Object o : target) {
      System.out.println(o);
    }
  }

  public static <T> List<T> removeDuplicate(List<T> target) {
    Set<T> set = new HashSet<>(target);
    return new ArrayList<>(set);

  }
}
