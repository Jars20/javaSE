package club.banyuan;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReverseHelloMultithreaded {

  static ExecutorService executorService = Executors.newFixedThreadPool(50);

  public static void doReverseHello() {
    helloThread(50);
  }

  public static void helloThread(int num) {
    if (num <= 50) {

      Future<String> future = executorService.submit(() -> {
        helloThread(num + 1);
        return num + "";
      });
      try {
        System.out.println("Hello from thread " + future.get());
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    executorService.shutdown();
  }
}
