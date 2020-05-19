package club.banyuan;

public interface Measurer<E>{

  /**
   * 计算对象的数量.
   */
  double measure(E anObject);
}