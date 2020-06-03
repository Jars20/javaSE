package tcp.duplex;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SocketUtil {

  /**
   * 从键盘接收数据，发送给socket另一方
   *
   * @param socket
   * @param sender
   * @param submit
   * @throws IOException
   */
  public static void communication(
      Socket socket, Sender sender, Future<?> submit) throws IOException {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String input = scanner.nextLine();
      if (input.trim().length() == 0) {
        // 过滤空行
        continue;
      }
      if ("quit".equals(input)) {
        System.out.println("退出");
        socket.close();
        submit.cancel(true);
        break;
      }

      sender.setMessage(input.getBytes());
    }
  }

  /**
   * 开启两个线程(读、写)实现双工通信
   *
   * @param socket
   * @throws IOException
   */
  public static void duplex(Socket socket) throws IOException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    Receiver receiver = new Receiver(socket.getInputStream());
    Sender sender = new Sender(socket.getOutputStream());

    executorService.submit(receiver);
    Future<?> submit = executorService.submit(sender);
    executorService.shutdown();

    communication(socket, sender, submit);
  }
}
