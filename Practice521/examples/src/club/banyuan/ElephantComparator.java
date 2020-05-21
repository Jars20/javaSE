package club.banyuan;

import java.util.Comparator;

public class ElephantComparator implements Comparator<ElephantNotComparable> {

  @Override
  public int compare(ElephantNotComparable o1, ElephantNotComparable o2) {
    return o1.getHeight() - o2.getHeight();
  }
}
