package club.banyuan;

class MaxThread extends Thread {

  private int low, high;
  private double Max;
  private int[] arr;

  MaxThread(int[] arr, int low, int high) {
    this.arr = arr;
    this.low = low;
    this.high = high;
    this.Max = Math.sin(arr[low]);
  }

  @Override
  public void run() {
    for (int i = low; i < high; i++) {
      if (Max<Math.sin(arr[i]))
        Max = Math.sin(arr[i]);
    }
  }


  public double getMax(){
    return Max;
  }
}

public class MaxMultithreaded {

  /**
   * 求数组元素的最大值。
   *
   * @param arr 目标数组
   * @return 数组元素的最大值
   * @throws InterruptedException 不应该出现此异常
   */
  public static double max(int[] arr, int numThreads) throws InterruptedException {
    int len = arr.length;
    double max = 0;
    MaxThread[] maxThreads = new MaxThread[numThreads];
    for (int i = 0; i < numThreads; i++) {
      maxThreads[i] = new MaxThread(arr,(i * len) / numThreads, ((i + 1) * len / numThreads));
      maxThreads[i].start();
    }

    for (int i = 0; i < numThreads; i++) {
      maxThreads[i].join();
      if (max<maxThreads[i].getMax())
        max = maxThreads[i].getMax();
    }
    return max;
  }
}
