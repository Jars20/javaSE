package tcp.duplex;

import java.io.IOException;
import java.io.InputStream;

public class Receiver implements Runnable {

  private InputStream inputStream;

  public Receiver(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  @Override
  public void run() {
    byte[] buf = new byte[1024];
    while (true) {
      try {
        int read = inputStream.read(buf);
        System.out.println("接收消息：" + new String(buf, 0, read));
      } catch (IOException e) {
        System.out.println("读取失败，退出线程");
        break;
      }
    }
  }
}
