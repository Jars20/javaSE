package club.banyuan.util.map;

public interface Map {

  /**
   * @return Map中的键值对数量
   */
  int size();

  /**
   * @return true Map没有保存键值对
   */
  boolean isEmpty();

  /**
   * @return true Map中保存的键值对中包含了传入的键
   */
  boolean containsKey(Object key);

  /**
   * @return true Map中保存了键值对中包含了传入的值
   */
  boolean containsValue(Object value);

  /**
   * 根据传入的键查询值，如果查询不到，则返回null
   */
  Object get(Object key);


  /**
   * 通过key保存value
   */
  Object put(Object key, Object value);

  /**
   * 移除key和保存的值
   */
  Object remove(Object key);

  interface Entry {

    Object getKey();

    Object getValue();

    void setValue(Object o);

    void setKey(Object o);

    boolean equals(Object o);

    int hashCode();
  }
}
