package club.banyuan;

public class VariableCapture {

  static int staticField = 499;
  int instanceField = 200;

  public static void main(String[] args) {

    int target = 100;

    // 局部变量捕获后，不能修改变量的值，因为变量是final或者effectively final的
    Comparable<Integer> comparable = o -> o.compareTo(target);

    // 编译报错，因为不能够在static 的main方法中直接使用成员变量，因为没有对象被创建
    // Comparable<Integer> comparable1 = new Comparable<>() {
    //   @Override
    //   public int compareTo(Integer o) {
    //     return o.compareTo(instanceField);
    //   }
    // };

    VariableCapture variableCapture = new VariableCapture();
    Comparable<Integer> integerComparable = variableCapture.variableCaptureTest();
    System.out.println(integerComparable.compareTo(300));
    variableCapture.instanceField = 400;
    System.out.println(integerComparable.compareTo(300));


    Comparable<Integer> comparable1 = o -> o.compareTo(staticField);
  }

  public Comparable<Integer> variableCaptureTest() {
    return o -> {
      // this.instanceField = 300;
      // instanceField = 400;
      return o.compareTo(instanceField);
    };
  }

}
