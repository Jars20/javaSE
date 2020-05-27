package club.banyuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamDemo {

  public static void main(String[] args) {

    File file = new File("demo.txt");
    OutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream(file);
      String target = Math.random() + "";
      outputStream.write(target.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (outputStream != null) {
          outputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try (InputStream inputStream = new FileInputStream(file)) {
      byte[] bytes = inputStream.readAllBytes();
      System.out.println("读取文件内容");
      System.out.println(new String(bytes));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
