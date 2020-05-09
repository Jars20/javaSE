package club.banyuan;

import club.banyuan.collection.ArrayList;
import club.banyuan.collection.List;
import club.banyuan.util.Iterator;

public class HashMap implements Map {

    public static final int INIT_LENGTH = 20;
    private List[] listArr = new List[INIT_LENGTH];
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        int hashCode = key.hashCode();
        List list = listArr[hashCode % INIT_LENGTH];
        if (list == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        } else {
            for (int i = 0; i < INIT_LENGTH; i++) {
                List list = listArr[i];
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    Entry entry = (Entry) iterator.next();
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override
    public Object get(Object key) {
        if (key == null) {
            return null;
        }

        int hashCode = key.hashCode();
        List list = listArr[hashCode % INIT_LENGTH];
        if (list == null) {
            return null;
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null) {
            return null;
        }

        int hashCode = key.hashCode();
        List list = listArr[hashCode % INIT_LENGTH];
        if (list == null) {
            list = new ArrayList();
            listArr[hashCode % INIT_LENGTH] = list;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return value;
            }
        }
        list.add(new Entry(key, value));
        size++;
        return value;
    }

    @Override
    public Object remove(Object key) {
        if (key == null) {
            return null;
        }

        int hashCode = key.hashCode();
        List list = listArr[hashCode % INIT_LENGTH];


        Iterator iterator = list.iterator();
        int keyIndex = 0;
        boolean findKey = false;            //增加一个标记是否找到key的boolean变量
        Object valuePrintout = null;
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            keyIndex++;
            if (entry.getKey().equals(key)) {
                valuePrintout = entry.getValue();
                findKey = true;
                break;
            }
        }
        if (findKey) {
            list.remove(keyIndex);
            return valuePrintout;
        }


        return null;
    }
}
