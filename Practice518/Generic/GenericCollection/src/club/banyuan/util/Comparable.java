package club.banyuan.util;

public interface Comparable {

  /**
   * -1 调用方小
   * 0 表示相等
   * 1 调用方大
   *
   * @param c
   * @return
   */
  int compareTo(Comparable c);
}
