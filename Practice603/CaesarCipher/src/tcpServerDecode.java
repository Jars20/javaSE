import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpServerDecode {

  public static final int FIRST_UPPER = 65;
  public static final int FIRST_LOWER = 97;
  public static final int NUM_CHARS = 26;
  public static final int OFFSET = 3;

  public static void main(String[] args) {
    BufferedReader inStream = null;
    BufferedWriter outStream = null;

    try (ServerSocket serverSocket = new ServerSocket(10000)) {
      System.out.println("服务器启动，等待客户端链接");
      Socket socket = serverSocket.accept();
      String Address = socket.getInetAddress().getHostAddress();
      System.out.println(Address + "客户端接入...");

      Socket socket1 = serverSocket.accept();
      inStream = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
      outStream = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));

      //得出bufferReader中的第一个字符的标记
      //0表示需要加密，1表示需要解密
      char[] flag = new char[1];
      inStream.read(flag);

      if (flag[0] == '1' | flag[0] == '0') {
        String Line = inStream.readLine();
        while (Line != null) {
          StringBuilder temp = new StringBuilder();
          char[] EnLine = Line.toCharArray();
          if (flag[0] == '1') {
            for (char c : EnLine) {
              temp.append(caesarDecode(c));
            }
          } else if (flag[0] == '0') {
            for (char c : EnLine) {
              temp.append(caesarEncode(c));
            }
          }
          outStream.write(temp.toString());
          outStream.newLine();
          outStream.flush();
          Line = inStream.readLine();
        }
      }else {
        System.out.println("格式错误");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("处理完毕");

  }

  public static char caesarDecode(char ch) {
    if (Character.isUpperCase(ch)) {
      return (char) ((ch - Encode.FIRST_UPPER + Encode.NUM_CHARS - Encode.OFFSET) % Encode.NUM_CHARS
          + Encode.FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - Encode.FIRST_LOWER + Encode.NUM_CHARS - Encode.OFFSET) % Encode.NUM_CHARS
          + Encode.FIRST_LOWER);
    } else {
      return ch;
    }
  }


  public static char caesarEncode(char ch) {

    if (Character.isUpperCase(ch)) {
      return (char) ((ch - FIRST_UPPER + OFFSET) % NUM_CHARS + FIRST_UPPER);
    } else if (Character.isLowerCase(ch)) {
      return (char) ((ch - FIRST_LOWER + OFFSET) % NUM_CHARS + FIRST_LOWER);
    } else {
      return ch;
    }
  }
}
