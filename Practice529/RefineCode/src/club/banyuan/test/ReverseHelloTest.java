package club.banyuan.test;

import club.banyuan.ReverseHelloMultithreaded;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class ReverseHelloTest {

  /**
   * 需要导入lib包下的 system-rules-1.19.0.jar
   * 用于接收控制台输入，然后和预设值进行比较
   */
  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void testReverseHello() {
    ReverseHelloMultithreaded.doReverseHello();
    String expectedOutput = "";
    for (int i = 50; i >= 1; i--) {
      expectedOutput += "Hello from thread " + i + System.lineSeparator();
    }
    assertEquals(expectedOutput, systemOutRule.getLog());
  }
}
