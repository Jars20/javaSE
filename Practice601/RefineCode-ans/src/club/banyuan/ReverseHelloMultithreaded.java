package club.banyuan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReverseHelloMultithreaded {
  static ExecutorService executorService = Executors.newFixedThreadPool(50);
  public static void doReverseHello() {
    helloThread(50);
  }

  public static void helloThread(int num) {
    if (num > 0) {
      executorService.submit(new Thread(() -> helloThread(num - 1), num + ""));
      System.out.println("Hello from thread " + num);
    }
  }
}
