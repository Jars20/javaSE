package tcp.duplex;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ServerSocket期间如果不进行accept处理， 最多会接收50个 客户端的连接
 * 之后的客户端连接将超时
 */
public class TcpServer {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(10000)) {
      System.out.println("服务端启动，等待客户端连接");
      Socket socket = serverSocket.accept();
      String hostAddress = socket.getInetAddress().getHostAddress();
      System.out.println(hostAddress + " 客户端接入。。");
      SocketUtil.duplex(socket);
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("服务器退出");
  }

}
