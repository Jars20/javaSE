package club.banyuan.machine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

public class VmsStorageUtil {

  static private Properties properties;

  private static void loadProperties() {
    InputStream is = VmsStorageUtil.class.getResourceAsStream("/vms.properties");
    try {
      properties.load(is);
    } catch (Exception e) {
      throw new VendingMachineException("读取文件失败");
    }
  }

  public static int getPassWord() {
    if (properties == null) {
      loadProperties();
    }
    try {
      return Integer.parseInt(properties.getProperty("password"));
    } catch (NumberFormatException e) {
      throw new VendingMachineException("属性错误");
    }
  }

  public static String getStoreFileName() {
    if (properties == null) {
      loadProperties();
    }
    try {
      return properties.getProperty("filename");
    } catch (NumberFormatException e) {
      throw new VendingMachineException("属性错误");
    }
  }

  public static void save(Serializable obj) {
    String classpath = VmsStorageUtil.class.getClassLoader().getResource("").getPath();
    File storageFile = new File(classpath,getStoreFileName());
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storageFile))) {
      oos.writeObject(obj);
    } catch (IOException e) {
      throw new VendingMachineException("保存失败",e);
    }
  }

  public static <T> T load(){
    String classPath = VmsStorageUtil.class.getClassLoader().getResource("").getPath();
    File storageFile = new File(classPath, getStoreFileName());
    try (ObjectInputStream inputStream = new ObjectInputStream(
        new FileInputStream(storageFile))) {
      return (T) inputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      throw new VendingMachineException("保存失败", e);
    }
  }

  public static void main(String[] args) {
    System.out.println(VmsStorageUtil.class.getClassLoader().getResource("").getPath());
    System.out.println(getPassWord());
  }

}
