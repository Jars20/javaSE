package club.banyuan;

import java.util.Iterator;

public class Pairs<K, V> implements Iterable<Pair<K, V>> {

    /* 声明一对对象的固定大小的数组（最多10个元素） */
    private final int CAPACITY = 10;
    private final Pair<K, V>[] pairs;
    private int size;

    /**
     * 创建一个集合，该集合将存储成对添加的项目。
     */
    public Pairs() {
        size = 0;
        pairs = new Pair[CAPACITY];
    }

    /**
     * 创建一个新的对，并在有空间的情况下将其添加到集合中。
     *
     * @param first  The first object.
     * @param second The second object.
     */

    @SuppressWarnings("unchecked")
    public boolean addPair(K first, V second) {
        if (size < 9) {
            Pair<K, V> newPair = new Pair<>(first, second);
            pairs[size++] = newPair;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Iterator<Pair<K, V>> iterator() {

        return new PairIterator();
    }

    /*
     * 根据以下位置的API文档在此处实现迭代器
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html
     * 按照规定抛出异常
     */


    private class PairIterator implements Iterator<Pair<K, V>> {
        int temp = 0;

        @Override
        public boolean hasNext() {
            if (temp < size) {
                temp++;
                return true;
            }
            throw new UnsupportedOperationException();
        }

        /**
         * 返回迭代器中的下一个对象
         */
        @Override
        public Pair<K, V> next() {
            if (temp+1<size) {
                Pair<K, V> output = pairs[temp++];
                return output;
            }
            throw new UnsupportedOperationException();
        }

        /**
         * 从集合中移除next（）返回的上一个对象。
         */
        @Override
        public void remove() {
            if (temp >= 1) {
//                Pair<K,V> output = pairs[temp-1];
                if (size - temp - 1 >= 0) System.arraycopy(pairs, temp - 1 + 1, pairs, temp - 1, size - temp - 1);
                size--;
                return;
            }
            throw new UnsupportedOperationException();
        }
    }

}