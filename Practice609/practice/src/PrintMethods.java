import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintMethods {

  public static void main(String[] args) {
    printInfo(0);
  }

  /**
   * 接收一个对象，输出对象类的所有方法和成员，分别按照名称升序排列
   *
   * @param object
   */
  public static void printInfo(Object object) {
    Class aClass = object.getClass();
    Field[] fields = aClass.getDeclaredFields();
    Method[] methods = aClass.getDeclaredMethods();

    List<Field> temp1 = new ArrayList<>(Arrays.asList(fields));
    List<Method> temp2 = new ArrayList<>(Arrays.asList(methods));

    temp1.sort(Comparator.comparing(Field::getName));
    System.out.println("=====================");
    temp2.sort(Comparator.comparing(Method::getName));

    /**
     * 由于成员变量为大写，小于方法name，直接先打印方法后打印成员变量
     */
    temp2.forEach(System.out::println);
    temp1.forEach(System.out::println);

  }

}
