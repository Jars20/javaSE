import java.util.Random;

public class Counter {

  private int value;
  private Random randomGenerator;

  /**
   * Constructor
   */
  public Counter() {
    value = 0;
    randomGenerator = new Random();
  }

  /**
   * 将counter每次加1，加10次，时不时地休息一下。
   */
  public void count() {
    int count = 0;
    try {
      while (count < 10) {
        // 使用这种方法增加出现并发问题的几率，不要修改此代码
        value = foo(value);

        // 生成一个0到5之间的随机数，使其睡眠时间在500ms左右
        Thread.sleep(randomGenerator.nextInt(6) * 100);

        count++;
      }
    } catch (InterruptedException e) {
      // 线程中断异常，暂时可以忽略
    }
  }

  public int get() {
    return value;
  }

  /**
   * @return n+1
   * @throws InterruptedException
   */
  private int foo(int n) throws InterruptedException {
    // 生成一个0到5之间的随机数，使其睡眠时间在500ms左右
    Thread.sleep(randomGenerator.nextInt(6) * 100);
    return n + 1;
  }

}
