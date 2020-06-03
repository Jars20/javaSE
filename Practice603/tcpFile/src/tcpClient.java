import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class tcpClient {

  public static void main(String[] args) {
    try (Socket socket = new Socket("192.168.9.228", 10000)) {
      System.out.println("客户端启动");

      byte[] bytes = new byte[1024];
      FileInputStream fileInputStream = new FileInputStream("test.txt");
      while (fileInputStream.read(bytes) != -1) {
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
      }


    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("客户端退出");
  }


}
