package club.banyuan;

public class DataSetTester2 {

  public static void main(String[] args) {
    Measurer m = new RectangleMeasurer();
    DataSet data = new DataSet(m);
    data.add(new Rectangle(15, 10));
    data.add(new Rectangle(40, 20));
    data.add(new Rectangle(20, 10));
    System.out.println("平均面积: " + data.getAverage());
    System.out.println("输出值: 410.0");
    Rectangle max = (Rectangle) data.getMaximum();  // Type casting
    System.out.println("最大面积矩形: " + max);
    System.out.println("期待输出值: Rectangle{width=40,height=20}");
  }
}
