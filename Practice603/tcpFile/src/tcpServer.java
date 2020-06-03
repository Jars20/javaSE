import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServer {

  public static void main(String[] args) {
    try (ServerSocket ss = new ServerSocket(10000)) {
      System.out.println(" 服务器启动，等待客户端链接");
      Socket socket = ss.accept();
      String Address = socket.getInetAddress().getHostAddress();
      System.out.println(Address + " 客户端接入..");

      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./test1.txt"));

      InputStream is = socket.getInputStream();
      byte[] bytes = new byte[1024];
      while (is.read(bytes) != -1) {
        bos.write(bytes);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("服务器退出");
  }
}
