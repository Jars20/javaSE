import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 用于向电话呼叫
 */
public class PhoneCallGenerator extends Thread {

  private CellularPhone phone;
//  public static final Lock lock = new ReentrantLock();
//  public static final Condition callCondition = lock.newCondition();

  public PhoneCallGenerator(String name, CellularPhone thePhone) {
    super(name);
    phone = thePhone;
  }

  public void run() {
    int counter = 0;
    Random randomGenerator = new Random();
    int maxCallLength = 3;

    // 生成20个电话
    try {
      while (counter++ < 20) {
        // 随机生成0到3秒之间的呼叫长度
        int length = randomGenerator.nextInt(maxCallLength);
        // 试着发起一个呼叫
//        lock.lock();
        if (phone.startCall(getName(), Integer.toString(counter))) {
          // 呼叫开始，休眠随机生成的时间，然后结束通话
          sleep(length * 1000);
          phone.endCall(getName(), Integer.toString(counter));
//          callCondition.signalAll();
//          callCondition.await();
        } else {
          // Sleep让其他线程有机会，然后告诉用户调用已被放弃
          System.out.println("<" + this.getName()
              + ">: Busy, call (" + counter + ") dropped");

          sleep(length * 1000);
        }
        // 让其他线程有机会
        sleep(randomGenerator.nextInt(2));
//        lock.unlock();
      }
    } catch (InterruptedException e) {
    }
  }
}
