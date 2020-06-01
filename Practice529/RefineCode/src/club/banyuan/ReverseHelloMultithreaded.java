package club.banyuan;

class HelloThread extends Thread {

  private final int Max;


  HelloThread(int Max) {
    this.Max = Max;
  }

  @Override
  public void run() {
    if (Max > 0) {
      System.out.println("Hello from thread " + Max);
      Thread child = new HelloThread(Max - 1);
      child.start();
    }
  }

}

public class ReverseHelloMultithreaded {

  private static int Max = 50;

  public static void doReverseHello() {
    HelloThread first = new HelloThread(Max);
    first.start();
  }
}
