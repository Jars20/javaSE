package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket期间如果不进行accept处理， 最多会接收50个 客户端的连接
 * 之后的客户端连接将超时
 */
public class TcpServer {

  public static void main(String[] args) throws IOException {
    try (ServerSocket serverSocket = new ServerSocket(10000)) {
      System.out.println("服务端启动，等待客户端连接");
      Socket socket = serverSocket.accept();
      String hostAddress = socket.getInetAddress().getHostAddress();
      System.out.println(hostAddress + " 客户端接入。。");

      InputStream inputStream = socket.getInputStream();
      // 读取数据直到流关闭，如果客户端写了一部分数据没有关闭流，则会一直阻塞
      // byte[] bytes = inputStream.readAllBytes();
      byte[] bytes = new byte[1024];
      int count = inputStream.read(bytes);
      System.out.println("来自客户端的消息:" + new String(bytes, 0, count));

      OutputStream outputStream = socket.getOutputStream();
      outputStream.write("消息收到了!".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("服务器退出");
  }
}
