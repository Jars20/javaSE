public class Driver {

  public static void main(String[] args) throws Exception {
    Counter c = new Counter();

    // 通过使用两个单独的线程将计数器增加到20
    Accessor one = new Accessor("one", c);
    Accessor two = new Accessor("two", c);

    // 启动线程
    one.start();
    two.start();

    // 等待每个线程完成
    one.join();
    two.join();
    System.out.println("计数器的值为 " + c.get()
        + ", 期待值为 20");
  }
}
