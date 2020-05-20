package club.banyuan;

import java.util.Iterator;

/**
 * 该代码说明了Pairs类的用法。
 */

public class PairsDriver {

  /**
   * Pairs类的测试程序。
   */
  public static void main(String[] args) {
    Pairs<String, Integer> pairs = new Pairs<String, Integer>();
    for (int i = 0; i < 15; i++) {
      pairs.addPair("A" + i, i);
    }

    /* 遍历并打印 */
    for (Pair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();

    Iterator<Pair<String, Integer>> iterator = pairs.iterator();
    while (iterator.hasNext()) {
      Pair<String, Integer> pair = iterator.next();
      /* 删除偶数位置的内容 */
      if ((pair.getSecond() % 2) == 0) {
        iterator.remove();
      }
    }

    /* 再次迭代并打印剩余的 */
    for (Pair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();

    /* 现在重新添加一些内容并确认已添加 */
    pairs.addPair("B", 10);

    for (Pair<String, Integer> pair : pairs) {
      System.out.println(pair.toString());
    }
    System.out.println();

  }
}