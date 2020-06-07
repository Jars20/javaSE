import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class tcpClientEncode {

  public static final int FIRST_UPPER = 65;
  public static final int FIRST_LOWER = 97;
  public static final int NUM_CHARS = 26;
  public static final int OFFSET = 3;

  /**
   * 输入上传文件存储地址。上传加密文件
   *
   * @param args
   */
  public static void main(String[] args) {
    BufferedReader inStream = null;
    BufferedWriter outStream = null;
    String inputPath = args[0];

    System.out.println("输入文件：" + inputPath);
    try (Socket socket = new Socket("192.168.31.131", 10000)) {
      inStream = new BufferedReader(new FileReader(inputPath));

      outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      System.out.println("客户端启动");

      //此处上传的是加密的文件，开头加'1'
      outStream.write('1');


      String Line = inStream.readLine();
      while (Line != null) {
        StringBuilder temp = new StringBuilder();
        char[] EnLine = Line.toCharArray();
        for (char c : EnLine) {
          temp.append(caesarEncode(c));
        }
        outStream.write(temp.toString());
        outStream.newLine();
        outStream.flush();
        Line = inStream.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


    System.out.println("上传加密文件成功");


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
