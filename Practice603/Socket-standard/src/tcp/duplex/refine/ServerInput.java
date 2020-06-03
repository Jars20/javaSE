package tcp.duplex.refine;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;

public class ServerInput implements Runnable {

  private List<Socket> socketList;
  private List<Sender> senderList;
  private ServerSocket serverSocket;

  public ServerInput(List<Socket> socketList, List<Sender> senderList, ServerSocket serverSocket) {
    this.socketList = socketList;
    this.senderList = senderList;
    this.serverSocket = serverSocket;
  }

  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext()) {
      String input = scanner.nextLine();
      if (input.trim().length() == 0) {
        // 过滤空行
        continue;
      }
      if ("quit".equals(input)) {
        socketList.forEach(t -> {
          try {
            t.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
        senderList.forEach(t -> t.getFuture().cancel(true));
        try {
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
      }
      senderList.forEach(t -> t.setMessage(input.getBytes()));
    }
    System.out.println("退出");
  }
}
