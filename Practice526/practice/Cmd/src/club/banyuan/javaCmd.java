package club.banyuan;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class javaCmd {

  public static final int SIZE = 1024;

  public static void main(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("输入错误!");
      return;
    }
    switch (args[0]) {
      case "ls":
        switch (args.length) {
          case 1: {
            File file = new File("./");
            String[] fileNames = file.list();
            if (file.listFiles() == null) {
              System.out.println("没有文件");
              return;
            }
            for (String fileName : fileNames) {
              System.out.println(fileName);
              return;
            }
          }
          case 2:
            if (args[1].equals("-l")) {
              File fileTemp = new File("./");
              creatFilesName(fileTemp);
              return;
            } else {
              File file = new File(args[1]);
              if (file.exists()) {
                String[] fileNames = file.list();
                for (String fileName : fileNames) {
                  System.out.println(fileName);
                }
              }
              return;
            }
          case 3:
            if (args[2].equals("-l")) {
              File fileTemp = new File(args[1]);
              creatFilesName(fileTemp);
            } else {
              System.out.println("输入格式错误!");
            }
        }
        break;

      case "cp":
        String fromPath = args[1];
        String toPath = args[2];
        File fileFrom = new File(fromPath);
        File fileTo = new File(toPath + File.separator + fileFrom.getName());
        fileTo.createNewFile();
        try (InputStream inputStream = new FileInputStream(fileFrom);
            OutputStream outputStream = new FileOutputStream(fileTo)) {
          byte[] temp = new byte[SIZE];
          int count;
          long perPercentage = fileFrom.length() / SIZE;
          long percentage = 0;
          System.out.println("开始复制");
          while ((count = inputStream.read(temp)) != -1) {
            outputStream.write(temp, 0, count);
            System.out.println(percentage + "%");
            percentage = percentage + perPercentage;
          }
          InputStream inputStream1 = new BufferedInputStream(inputStream);

          System.out.println("复制成功");
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;

      case "rm":
        File fileToRemove = new File(args[1]);
        if (fileToRemove.exists()) {
          deleteFile(fileToRemove);
          System.out.println("删除成功");
        } else {
          System.out.println("删除失败：路径错误");
        }
        break;

      case "cat":
        File fileToDisplay = new File(args[1]);
        InputStream inputStream = new FileInputStream(fileToDisplay);
        byte[] bytes = inputStream.readAllBytes();
        System.out.println("输出结果：");
        System.out.println(new String(bytes));
        inputStream.close();
        break;
      default:
        System.out.println("invalid input!");
    }

  }

  private static void creatFilesName(File fileTemp) {
    File[] files = fileTemp.listFiles();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (File file : files) {
      System.out.printf("%-24s", file.isDirectory() ? "d" : "-");
      System.out.printf("%-16d", file.length());
      System.out.printf("%-24s", dateFormat.format(new Date(file.lastModified())));
      System.out.println(file.getName());
    }
  }

  private static void deleteFile(File fileToDelete) {
    if (fileToDelete.isDirectory()) {
      if (fileToDelete.listFiles() != null) {
        for (File file : fileToDelete.listFiles()) {
          deleteFile(file);
        }
      }
      fileToDelete.delete();
    }
  }
}