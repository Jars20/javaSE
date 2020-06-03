package udp.combination;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.Future;

public class UdpClient implements Runnable {

  private UdpServer udpServer;

  public UdpClient(UdpServer udpServer) {
    this.udpServer = udpServer;
  }

  @Override
  public void run() {
    // ip port 消息
    Scanner scanner = new Scanner(System.in);
    DatagramSocket ds = null;
    boolean isRunning = true;
    try {
      ds = new DatagramSocket();
    } catch (SocketException e) {
      System.err.println("开启DatagramSocket失败");
      System.exit(0);
    }

    while (isRunning) {
      while (scanner.hasNext()) {
        String input = scanner.nextLine();
        if (input.trim().length() == 0) {
          // 过滤空行
          continue;
        }
        if ("quit".equals(input)) {
          System.out.println("退出");
          isRunning = false;
          udpServer.setRunning(false);
          udpServer.getDatagramSocket().close();
          break;
        }

        String[] source = input.split(" ");
        if (source.length < 3) {
          System.out.println("消息不合法");
          continue;
        }
        byte[] bytes = source[2].getBytes();
        try {
          DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
              InetAddress.getByName(source[0]),
              Integer.parseInt(source[1]));
          ds.send(dp);
        } catch (IOException e) {
          System.err.println("发送失败！");
          e.printStackTrace();
        } catch (NumberFormatException e) {
          System.out.println("消息不合法");
        }
      }
    }

    ds.close();
    System.out.println("客户端退出！");
  }
}
