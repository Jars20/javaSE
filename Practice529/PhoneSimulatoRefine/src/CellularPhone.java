import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.DefaultListSelectionModel;
import org.w3c.dom.ls.LSOutput;

public class CellularPhone extends Thread {

  private volatile boolean callInProgress = false;
  private volatile boolean keepGoing = true;
  private volatile List<String> Message = new ArrayList<>();

  private static final Lock lock = new ReentrantLock();
  private static final Condition callCondition = lock.newCondition();

  public CellularPhone(String name) {
    super(name);

  }

  /**
   * 假设控制台是手机的窗口。
   *
   * @param message 要显示的消息
   */
  void display(String message) {
    System.out.println(message);
  }

  /**
   * 接听电话。在终端显示消息。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 呼叫正在进行时显示的消息
   * @returns 如果调用被接受，则为true
   */
  public boolean startCall(String name, String callDisplayMessage) {
    if (callInProgress) {
      return false;
    } else {
      lock.lock();
      display("<" + name + ">: Call (" + callDisplayMessage + ") begins");
      callInProgress = true;
      return true;
    }

  }

  /**
   * 挂断电话。在此方法完成后，电话能够接听其他电话。
   *
   * @param name               调用方的名称
   * @param callDisplayMessage 要显示的消息
   */
  public void endCall(String name, String callDisplayMessage) {
    display("   <" + name + ">: Call (" + callDisplayMessage + ") ends");
    callInProgress = false;
    lock.unlock();
  }

  /**
   * 显示手机正在等待做某事
   */
  private void displayWaiting() {
    display("<" + this.getName() + ">: Waiting...");
  }

  public synchronized void addMessage(String newMessage) {
    Message.add(newMessage);
  }

  public synchronized void displayMessages() {
    Message.forEach(t -> System.out.println("<Phone>: Message: " + t));
    Message = new ArrayList<>();
  }


  /**
   * 停止电话接听程序
   */
  public void stopPhone() {
    keepGoing = false;
  }

  /**
   * 运行模拟器
   */
  public void run() {
    // 循环直到stopPhone被调用
    while (keepGoing) {
      // 如果没有电话
      if (!callInProgress) {
        displayWaiting();
        displayMessages();
        // 假装手机在做别的事情
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
