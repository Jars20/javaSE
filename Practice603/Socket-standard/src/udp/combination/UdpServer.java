package udp.combination;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer implements Runnable {

  private volatile boolean isRunning = true;
  private DatagramSocket datagramSocket = null;

  public void setRunning(boolean running) {
    isRunning = running;
  }

  public DatagramSocket getDatagramSocket() {
    return datagramSocket;
  }

  @Override
  public void run() {

    try {
      datagramSocket = new DatagramSocket(10000);
    } catch (SocketException e) {
      System.err.println("开启DatagramSocket失败");
      System.exit(0);
    }
    byte[] bytes = new byte[1024];
    while (isRunning) {
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
      try {
        datagramSocket.receive(dp);
        byte[] data = dp.getData();
        String message = new String(data, 0, dp.getLength());
        System.out.println(dp.getAddress().getHostAddress() + ":" + message);
      } catch (IOException e) {
        System.out.println("停止接收数据");
      }
    }
    if (!datagramSocket.isClosed()) {
      datagramSocket.close();
    }
    System.out.println("服务端退出！");
  }
}
