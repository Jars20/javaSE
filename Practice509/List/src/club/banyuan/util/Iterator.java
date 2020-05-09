package club.banyuan.util;

import club.banyuan.collection.List;

public class Iterator {

  private List list;
  private int pos;

  public Iterator(List list) {
    this.list = list;
  }

  public boolean hasNext() {
    return list.size() > pos;
  }

  public Object next() {
    return list.get(pos++);
  }


}
