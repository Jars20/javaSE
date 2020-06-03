package tcp.duplex.refine;

import java.io.IOException;
import java.net.Socket;

public class TcpClient {

  public static void main(String[] args) {
    try (Socket socket = new Socket("127.0.0.1", 10000)) {
      System.out.println("客户端启动");
      SocketUtil.duplex(socket);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("客户端退出");
  }

}
