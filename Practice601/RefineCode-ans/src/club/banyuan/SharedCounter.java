package club.banyuan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SharedCounter {

  static int counter = 0;


  public static void reset() {
    counter = 0;
  }


//  static class SharedCallable implements Callable<Integer> {
//
//    private final int count;
//
//    public SharedCallable(int counter) {
//      this.count = counter;
//    }
//
//    @Override
//    public Integer call() throws Exception {
//      return count;
//    }
//  }

  public static int increment(int numThreads, int numIncrementsPerThread)
      throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
//    List<Future<Integer>> rlt = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      synchronized(SharedCounter.class){
        counter+=numIncrementsPerThread;
      }
//      SharedCallable one = new SharedCallable(numIncrementsPerThread);
//      rlt.add(executorService.submit(one));
    }
    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MICROSECONDS);


//    for (int i = 0; i < numThreads; i++) {
//      try {
//        Future<Integer> future = rlt.get(i);
//        future.get();
//        counter+=future.get();
//      } catch (ExecutionException e) {
//        e.printStackTrace();
//      }
//  }

    return counter;
}
}
