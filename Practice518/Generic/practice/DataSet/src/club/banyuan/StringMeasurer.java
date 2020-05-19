package club.banyuan;

public class StringMeasurer<E> implements Measurer<E> {

  @Override
  public double measure(E anObject) {
    if (anObject == null) {
      return 0;
    }
    if (anObject instanceof String) {
      String string = (String) anObject;
      return string.length();
    }
    throw new IllegalArgumentException("不是字符串类");
  }
}
