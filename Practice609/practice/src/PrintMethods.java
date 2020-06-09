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

    temp1.sort(new Comparator<Field>() {
      @Override
      public int compare(Field o1, Field o2) {
        /*
         * int compare(Field o1, Field o2) 返回一个基本类型的整型，
         * 返回负数表示：o1小于o2，
         * 返回0 表示：o1和o2相等，
         * 返回正数表示：o1大于o2
         */
        return o1.getName().compareTo(o2.getName());
      }
    });
    System.out.println("=====================");
    temp2.sort(new Comparator<Method>() {
      @Override
      public int compare(Method o1, Method o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });

    /**
     * 由于成员变量为大写，大于方法name，直接先打印方法后打印成员变量
     */
    temp2.forEach(System.out::println);
    temp1.forEach(System.out::println);

  }

}
