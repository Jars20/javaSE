package club.banyuan;

public class DataSetTester3 {

  public static void main(String[] args) {
    Measurer m = new StringMeasurer();
    DataSet data = new DataSet(m);
    data.add("test");
    data.add("testing");
    data.add("tester");
    data.add("retest");
    data.add("contest");
    System.out.println("Average length: " + data.getAverage());
    System.out.println("输出值: 6");
    String maxlength = (String) data.getMaximum();  // Type casting
    System.out.println("最大长度的字符串是: " + maxlength);
    System.out.println("输出值:testing");
  }
}
