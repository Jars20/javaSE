package club.banyuan;

public class RectangleMeasurer<E> implements Measurer<E> {

  @Override
  public double measure(E anObject) {
    if (anObject instanceof Rectangle) {
      Rectangle rectangle = (Rectangle) anObject;
      return rectangle.width * rectangle.height;
    }
    throw new IllegalArgumentException("不是矩形类");
  }
}
