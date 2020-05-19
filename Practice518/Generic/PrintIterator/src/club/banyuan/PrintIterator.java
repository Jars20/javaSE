package club.banyuan;

import java.util.Iterator;

public class PrintIterator {                                        //泛型只能用来修饰非静态变量。如果为泛型方法则没这个限制
    public static <T> void PrintIter(Iterable<T> input) {
        Iterator<T> iterator = input.iterator();
        while (iterator.hasNext()) {
            T temp = iterator.next();
            System.out.println(temp.toString());
            System.out.println(",");
        }
    }
}
