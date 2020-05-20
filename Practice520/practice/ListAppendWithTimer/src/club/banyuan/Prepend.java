package club.banyuan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较在基于数组的列表和基于链表的列表的第一个元素前插入n个值所需的时间
 * <p>
 * 1.创建一个计时器。
 * <p>
 * 2.计算将n个值添加到空链表的时间：
 * a.创建一个空的链表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 * <p>
 * 3.计算将n个值添加到空数组列表的时间：
 * a.创建一个空的数组列表
 * b.启动计时器
 * c.依次将0..n-1中的每个值i插入到list中
 * d.停止计时器
 * e.显示时间
 */
public class Prepend {
    public static void main(String args[]) {
        TimerImpl test2 = new TimerImpl();
        int n = 10000;
        List<Integer> TestArra = new ArrayList<>();
        test2.reset();
        test2.start();
        for (int i = 0; i < n; i++) {
            TestArra.add(0, i);
        }
        test2.stop();
        System.out.println("Array头插法实现类的插入耗时为" + test2.getTimeMillisecond()+"毫秒");
        test2.reset();


        List<Integer> TestLink = new LinkedList<>();
        test2.reset();
        test2.start();
        for (int i = 0; i < n; i++) {
            TestLink.add(0, i);
        }
        test2.stop();
        System.out.println("Link头插法实现类的耗时为" + test2.getTimeMillisecond()+"毫秒");
        test2.reset();
    }
}