import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOString {

  public static String[] loadArray(InputStream is, int[] n) throws IOException {
    List<String> list = new ArrayList<>();
    for (int i : n) {
      byte[] b = new byte[i];

      try {
        if (is.read(b) != i) {
          list.add(new String(b));
        } else {
          throw new RuntimeException();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return list.toArray(new String[list.size()]);
  }

  void saveArray(OutputStream os, String[] sa) throws IOException {
    for (String s : sa) {
      os.write(s.getBytes());
    }
    try {
      os.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void printMultiplication(String path, int n) throws IOException {
    OutputStream outputStream = new FileOutputStream(new File(path));
    for (int i = 1; i <= n; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int j = 1; j <= n; j++) {
        stringBuilder.append(String.format("%d", i * j));
      }
      stringBuilder.append(System.lineSeparator());
      outputStream.write(stringBuilder.toString().getBytes());
    }
  }
}
