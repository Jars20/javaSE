package club.banyuan.area;

public class AreaCalculator {

  public void show(Shape shape) {
    System.out.println(shape.getShapeName() + "面积是" + String.format("%.1f", shape.area()));
    System.out.println(shape.getShapeName() + "周长是" + String.format("%.1f", shape.perimeter()));
  }
}
