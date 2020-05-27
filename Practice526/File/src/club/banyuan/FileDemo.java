package club.banyuan;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// java -cp xxx club.banyuan.Main jls -l
// jls 查询文件或路径下面的内容
// jcp   jmv  jrm   jmkdir
public class FileDemo {

  public static void main(String[] args) throws IOException {
    File file = new File("demo.txt");

    System.out.println("文件是否存在:" + file.exists());

    boolean isCreateSuccess = file.createNewFile();
    System.out.println("文件创建成功?" + isCreateSuccess);

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    if (file.exists()) {
      System.out.println("文件还是文件夹" + file.isDirectory());
      System.out.println("文件大小" + file.length());
      System.out.println("文件的修改时间" + dateFormat.format(new Date(file.lastModified())));
    }

    System.out.println("文件删除成功？" + file.delete());

    File relativeFile = new File("demo.txt");

    relativeFile.createNewFile();

    System.out.println("文件路径：" + relativeFile.getAbsolutePath());
    System.out.println("文件路径：" + relativeFile.getCanonicalPath());

    // String rootPath = "/Users/liyi/filetest/uploadFile";
    // String filename = "../../test";
    // File uploadFile = new File(rootPath, filename);
    // if (!uploadFile.getCanonicalPath().equals(uploadFile.getAbsolutePath())) {
    //   throw new RuntimeException("路径含有相对路径");
    // }

    // if (!uploadFile.getParentFile().exists()) {
    //   uploadFile.getParentFile().mkdirs();
    // }
    // uploadFile.createNewFile();
    // System.out.println(uploadFile.getCanonicalPath());

    System.out.println(File.pathSeparator);// ;
    System.out.println(File.separator);  // \
  }
}
