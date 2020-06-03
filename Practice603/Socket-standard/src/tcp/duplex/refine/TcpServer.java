package tcp.duplex.refine;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ServerSocket期间如果不进行accept处理， 最多会接收50个 客户端的连接
 * 之后的客户端连接将超时
 */
public class TcpServer {

  public static void main(String[] args) {
    List<Socket> socketList = new CopyOnWriteArrayList<>();
    List<Sender> senders = new CopyOnWriteArrayList<>();
    ExecutorService executorService = Executors.newCachedThreadPool();

    try (ServerSocket serverSocket = new ServerSocket(10000)) {
      executorService.submit(new ServerInput(socketList, senders, serverSocket));
      while (!serverSocket.isClosed()) {
        try {
          System.out.println("服务端启动，等待客户端连接");
          Socket socket = serverSocket.accept();
          String hostAddress = socket.getInetAddress().getHostAddress();
          System.out.println(hostAddress + " 客户端接入。。");

          Receiver receiver = new Receiver(socket.getInputStream());
          Sender sender = new Sender(socket.getOutputStream());

          executorService.submit(receiver);
          Future<?> submit = executorService.submit(sender);
          sender.setFuture(submit);

          socketList.add(socket);
          senders.add(sender);

        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
    System.out.println("服务器退出");
  }

}
