public class Accessor extends Thread {

  private Counter counter;

  public Accessor(String name, Counter theCounter) {
    super(name);
    counter = theCounter;
  }

  /**
   * 将counter每次加1，加10次，时不时地休息一下。
   */
  public void run() {
    synchronized (counter) {
      counter.count();
    }
  }

}
