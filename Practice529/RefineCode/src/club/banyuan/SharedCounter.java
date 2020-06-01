package club.banyuan;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CounterThread extends Thread {
  private int num;
  private int count;

  public CounterThread(int num, int count) {
    this.num = num;
    this.count = count;
  }

  @Override
  public void run() {
    count += num;
  }
  public int getCount() {
    return count;
  }
}


public class SharedCounter {


  public static int counter = 0;


  public static void reset() {
    counter = 0;
  }


  public static int increment(int numThreads, int numIncrementsPerThread)
      throws InterruptedException {
    CounterThread[] ct = new CounterThread[numThreads];

    for (int i = 0; i < numThreads; i++) {
      ct[i]= new CounterThread(numIncrementsPerThread, counter);
      ct[i].start();
    }

    for (int i = 0; i <numThreads ; i++) {
      ct[i].join();
      counter+=ct[i].getCount();
    }


    return counter;
  }


}
