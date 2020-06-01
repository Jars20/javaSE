import java.util.Random;

public class Philosopher extends Thread {

  public final int code;
  public final Chopsticks left, right;
  private int eatCount, thinkCount;

  public Philosopher(int code, Chopsticks[] chopsticks) {
    this.code = code;
    this.setName("哲学家" + code + "");
    this.left = chopsticks[code - 1];
    this.right = chopsticks[(code + 1) % 5];
    this.eatCount = 0;
    this.thinkCount = 0;
  }

  public int getEatCount() {
    return eatCount;
  }

  public void setEatCount(int eatCount) {
    this.eatCount = eatCount;
  }

  public int getThinkCount() {
    return thinkCount;
  }

  public void setThinkCount(int thinkCount) {
    this.thinkCount = thinkCount;
  }

  public void thinking() {
    this.thinkCount++;
    System.out.println(getName() + ",思考,思考了" + thinkCount + "次");
    try {
      sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(getName() + ",思考结束");

  }

  public void eating() {
    if (!left.get(500)) {
      System.out.println("没拿到筷子，不吃了");
      return;
    }
    try {
      sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (!right.get(500)) {
      System.out.println("没拿到筷子，不吃了");
      left.putDown();
      return;
    }
    this.eatCount++;
    System.out.println(getName() + ",吃饭" + ",吃了" + eatCount + "次");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    left.putDown();
    right.putDown();
    System.out.println(getName() + ",吃饭结束");
  }


  @Override
  public void run() {
    Random random = new Random();
    while (true) {
      if (random.nextBoolean()) {
        eating();
      } else {
        thinking();
      }
    }

  }
}
