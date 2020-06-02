package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("请输入： ");
      String word = sc.nextLine();

      DatagramSocket ds = new DatagramSocket();
      byte[] bytes = word.getBytes();
      System.out.println(InetAddress.getLocalHost());
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
          InetAddress.getByName("192.168.9.228"),
          10000);
      ds.send(dp);

      ds.close();
    }
  }
}
