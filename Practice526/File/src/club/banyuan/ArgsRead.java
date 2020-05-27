package club.banyuan;

import jdk.jfr.StackTrace;
import org.junit.Test;

public class ArgsRead {

  public static void main(String[] args) {
    for (String arg : args) {
      System.out.println(arg);
    }
  }

//  @Test
//  public void test() {
//    main(new String[]{"ls","/Users"});
//  }
}
