import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

public class Decode {

  public static void main(String[] args) throws IOException {
    BufferedReader inStream = null;
    BufferedWriter outStream = null;

    String inputFilePath = args[0];
    String outputFilePath = args[1];

    System.out.println("输入文件：" + inputFilePath);
    System.out.println("输出文件：" + outputFilePath);
    // TODO

    //完成此部分代码，调用 caesarDecode 对传入的inputFilePath文件进行解密
    //将解密后的文本输出到 outputFilePath 文件中
    //尝试将alice.code进行解密
    inStream = new BufferedReader(new FileReader(inputFilePath));
    outStream = new BufferedWriter(new FileWriter(outputFilePath));

    // String s = inStream.readLine();
    cipher(inStream, outStream, Decode::caesarDecode);
    System.out.println("解密成功！");
  }

  public static void cipher(BufferedReader inStream, BufferedWriter outStream, Function<Character,Character> function) throws IOException {
    inStream.lines().forEach(t -> {
      char[] chars = t.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        chars[i] = function.apply(chars[i]);
        // chars[i] = caesarDecode(chars[i]);
      }
      try {
        outStream.write(chars);
        outStream.newLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    char[] test = new char[100];
    for (int i = 0; i < test.length; i++) {
      callMethod();
    }


    inStream.lines().forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
          chars[i] = function.apply(chars[i]);
          // chars[i] = caesarDecode(chars[i]);
        }
        try {
          outStream.write(chars);
          outStream.newLine();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
    inStream.close();
    outStream.close();
  }

  private static void callMethod() {

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

}

