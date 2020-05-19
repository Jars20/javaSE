package club.banyuan.util;

import club.banyuan.collection.List;

public class Iterator<T> {

  private List<T> list;
  private int pos;

  public Iterator(List<T> list) {
    this.list = list;
  }

  public boolean hasNext() {
    return list.size() > pos;
  }

  public T next() {
    return list.get(pos++);
  }
}
