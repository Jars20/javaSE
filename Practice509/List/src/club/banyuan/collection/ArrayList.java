package club.banyuan.collection;

import club.banyuan.util.Iterator;
import java.util.Arrays;

public class ArrayList implements List {

  private static final int DEFAULT_CAPACITY = 20;
  private int capacity;
  private Object[] data;
  private int size;

  public ArrayList(int capacity) {
    if (capacity < 0) {
      System.out.println("请输入合法的容量构造");
    } else {
      this.capacity = capacity;
      this.data = new Object[this.capacity];
    }
  }

  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }

  @Override
  public Object set(int index, Object element) {
    if (isLegal(index)) {
      return null;
    }
    Object temp = data[index];
    data[index] = element;
    return temp;
  }

  @Override
  public Object get(int index) {
    if (isLegal(index)) {
      return null;
    }
    return data[index];
  }

  @Override
  public void clear() {
    Arrays.fill(data, null);
    size = 0;
  }

  @Override
  public Object remove(int index) {
    if (isLegal(index)) {
      return null;
    }
    Object temp = data[index];
    if (index == size - 1) {
      data[index] = null;
    } else {
      System.arraycopy(data, index + 1, data, index, size - index);
    }
    size--;
    return temp;
  }

  @Override
  public boolean remove(Object o) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(o)) {
        remove(i);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean add(Object o) {
    addCapacity();
    data[size++] = o;
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

  @Override
  public Iterator iterator() {
    return new Iterator(this);
  }

  //判断下标是否合法
  private boolean isLegal(int index) {
    if (index >= size || index < 0) {
      System.out.println("下标不合法");
      return true;
    } else {
      return false;
    }
  }

  //增加容量
  private void addCapacity() {
    if (data.length == size) {
      capacity += DEFAULT_CAPACITY;
      Object[] newArray = new Object[capacity];
      System.arraycopy(data, 0, newArray, 0, data.length);
      data = newArray;
    }
  }

}