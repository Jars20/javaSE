package club.banyuan;

public class ArrayList implements List {
    private static final int DEFAULT_CAPACITY = 20;
    private int size;
    private int capacity;
    private Object[] arrayList;

    public ArrayList(int capacity) {
        if (capacity < 0) {
            System.out.println("请输入合法的容量");
            return;
        }
        this.capacity = capacity;
        this.arrayList = new Object[this.capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }


    @Override
    public Object set(int index, Object element) {
        if (isLegal(index)) {
            Object printout = arrayList[index];
            arrayList[index] = element;
            return printout;
        }
        return null;
    }

    @Override
    public Object get(int index) {
        if (isLegal(index)) {
            Object printout = arrayList[index];
            return printout;
        }
        return null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arrayList[i] = null;
        }
        size = 0;
    }

    @Override
    public Object remove(int index) {
        if (isLegal(index)) {
            Object printout = DeleteObject(index);
            return printout;
        }
        return null;
    }


    @Override
    public boolean remove(Object o) {
        int index = 0;
        while (arrayList[index] != o) {
            index++;
            if (index >= size) {
                System.out.println("找不到该元素");
                return false;
            }
        }
        if (isLegal(index)) {
            System.out.println(DeleteObject(index));
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Object o) {                  //  新建一个数组，数组大小比size大，拷贝原数组入新数组
        addCapacity();
        arrayList[size++] = o;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    //扩容数组
    private void addCapacity() {
        if (arrayList.length == size) {
            capacity += DEFAULT_CAPACITY;
            Object[] newArray = new Object[capacity];
            System.arraycopy(arrayList, 0, newArray, 0, arrayList.length);
            arrayList = newArray;
        }
    }

    //判断下标是否合法
    private boolean isLegal(int index) {
        if (index < size && index >= 0) {
            return true;
        } else
            System.out.println("输入下标不合法");
        return false;
    }

    // 删除规定下标的数组元素
    private Object DeleteObject(int index) {
        Object printout = arrayList[index];
        for (int i = index; i < size; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        size--;
        return printout;
    }


}
