package club.banyuan;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MaxCallable implements Callable {

  private int lo, hi;
  private int[] arr;
  private double ans = 0;

  public MaxCallable(int[] arr, int lo, int hi) {
    this.lo = lo;
    this.hi = hi;
    this.arr = arr;
  }


  public double getAns() {
    return ans;
  }

  @Override
  public Object call() throws Exception {
    ans = Math.sin(arr[lo]);
    for (int i = lo; i < hi; i++) {
      double sin = Math.sin(arr[i]);
      if (ans < sin) {
        ans = sin;
      }
    }
    return ans;
  }
}

public class MaxMultithreaded {

  /**
   * 计算数组元素的sin值之后，返回最大值。
   *
   * @param arr 目标数组
   * @return sin(数组元素)的最大值
   * @throws InterruptedException 不应该出现此异常
   */
  public static double max(int[] arr, int numThreads) throws InterruptedException {
    int len = arr.length;
    double ans = Double.NEGATIVE_INFINITY;

    // 创建并启动线程。
    MaxCallable[] ts = new MaxCallable[numThreads];
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

    for (int i = 0; i < numThreads; i++) {
      ts[i] = new MaxCallable(arr, (i * len) / numThreads, ((i + 1) * len / numThreads));
      executorService.submit(ts[i]);
    }

    // 等待线程完成并计算它们的结果。
    for (int i = 0; i < numThreads; i++) {
      if (ans < ts[i].getAns()) {
        ans = ts[i].getAns();
      }
    }
    return ans;
  }
}
