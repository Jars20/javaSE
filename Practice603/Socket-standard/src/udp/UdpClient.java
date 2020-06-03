package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

  public static void main(String[] args) throws IOException {
    DatagramSocket ds = new DatagramSocket();
    String word = "你好";
    byte[] bytes = word.getBytes();
    DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.118.2"),
        10000);
    ds.send(dp);

    ds.close();
  }
}
