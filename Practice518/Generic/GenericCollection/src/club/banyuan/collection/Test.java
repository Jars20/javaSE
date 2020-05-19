package club.banyuan.collection;

public class Test {

  public static void main(String[] args) {
    int[] ints = new int[5];
    Integer[] integers = new Integer[5];
    Object[] objects = integers;
    for (Object object : objects) {
      System.out.println(object instanceof Integer);
      System.out.println('a' > 1);
    }
    Integer[] integers1 = (Integer[]) objects;
    for (Integer integer : integers1) {
      // System.out.println(integer > 1);
    }

    objects = new Object[5];
    // integers1 = (Integer[]) objects;

    // (Object[])new Integer[5];

  }
}
