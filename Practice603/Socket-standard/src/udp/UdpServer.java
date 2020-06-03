package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

  public static void main(String[] args) throws IOException {
    DatagramSocket ds = new DatagramSocket(10000);
    byte[] bytes = new byte[1024];
    while (true){
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
      System.out.println("Before received");
      System.out.println(dp.getAddress());
      System.out.println(dp.getPort());
      ds.receive(dp);
      System.out.println("After received");
      byte[] data = dp.getData();
      System.out.println(data == bytes);
      System.out.println(new String(data,0, dp.getLength()));
      System.out.println(dp.getAddress().getHostAddress());
      System.out.println(dp.getPort());
    }

    // ds.close();
  }
}
