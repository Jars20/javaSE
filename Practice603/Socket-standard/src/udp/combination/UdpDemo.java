package udp.combination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UdpDemo {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(2);
    UdpServer udpServer = new UdpServer();
    UdpClient udpClient = new UdpClient(udpServer);
    executorService.submit(udpServer);
    executorService.submit(udpClient);
    executorService.shutdown();

  }

}
