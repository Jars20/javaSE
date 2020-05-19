package club.banyuan.collection;
import club.banyuan.util.Iterable;

public interface List<T> extends Iterable<T> {

  /**
   * 更新指定下标位置的元素
   *
   * @param index   替换的位置
   * @param element 替换后的元素
   * @return 被替换掉的元素
   */
  T set(int index, T element);


  /**
   * 根据下标获取元素
   *
   * @param index 下标
   * @return
   */
  T get(int index);

  /**
   * 清空集合中的所有元素
   */
  void clear();

  /**
   * 删除指定位置的元素
   *
   * @param index
   * @return 返回被删除掉的元素的引用，如果传入index不合法，返回null
   */
  T remove(int index);

  /**
   * 查找匹配的元素并删除，找到第一个元素删除即可
   *
   * @param o
   * @return true 被删除的元素存在，并且成功被移除
   */
  boolean remove(T o);

  /**
   * @param o 添加元素
   * @return true 添加成功
   */
  boolean add(T o);

  /**
   * @return true 空集合， false 集合中包含元素
   */
  boolean isEmpty();

  /**
   * @return 集合中元素个数
   */
  int size();
}
