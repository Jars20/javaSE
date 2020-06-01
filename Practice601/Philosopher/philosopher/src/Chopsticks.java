import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsticks {

  public final int code;
  Lock lock = new ReentrantLock();

  public Chopsticks(int code) {
    this.code = code;
  }


  public void putDown() {
    System.out.println(Thread.currentThread().getName() + "放下筷子: " + code);
    lock.unlock();
  }

  public void get() {
    System.out.println(Thread.currentThread().getName() + ",准备拿起筷子: " + code);
    lock.lock();
    System.out.println(Thread.currentThread().getName() + "拿起筷子: " + code);
  }

  public boolean get(long maxWaitTime) {
    System.out.println(Thread.currentThread().getName() + "准备拿起筷子: " + code);
    try{
      if(!lock.tryLock(maxWaitTime, TimeUnit.MILLISECONDS)){
        return false;
      }
    }catch (InterruptedException e){
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName()+"拿起筷子: "+code);
    return true;
  }

}
