package club.banyuan.util.map;

import club.banyuan.collection.ArrayList;
import club.banyuan.collection.List;
import club.banyuan.util.Iterator;
import java.util.Objects;

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
    return false;
  }

  @Override
  public boolean containsValue(Object value) {
    return false;
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

    int hashCode = Math.abs(key.hashCode());
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
    Object value = get(key);
    Entry entry = new Entry(key, value);
    for (List list : listArr) {
      list.remove(entry);
    }
    return null;
  }

  private static class Entry implements Map.Entry {

    Object key;
    Object value;

    public Entry(Object key, Object value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public Object getKey() {
      return key;
    }

    @Override
    public Object getValue() {
      return value;
    }

    @Override
    public void setValue(Object o) {
      this.value = o;
    }

    @Override
    public void setKey(Object o) {
      this.key = o;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Entry entry = (Entry) o;
      return Objects.equals(key, entry.key) &&
          Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, value);
    }
  }
}
