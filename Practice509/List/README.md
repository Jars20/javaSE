### List 接口
```  
/**
* 更新指定下标位置的元素
*
* @param index   替换的位置
* @param element 替换后的元素
* @return 被替换掉的元素
*/
Object set(int index, Object element);


/**
 * 根据下标获取元素
 *
 * @param index 下标
 * @return
 */
Object get(int index)

/**
* 清空集合中的所有元素
*/
void clear()

/**
* 删除指定位置的元素
*
* @param index
* @return 返回被删除掉的元素的引用，如果传入index不合法，返回null
*/
Object remove(int index)

/**
* 查找匹配的元素并删除
*
* @param o
* @return true 被删除的元素存在，并且成功被移除
*/
boolean remove(Object o)

/**
* @param o 添加元素
* @return true 添加成功
*/
boolean add(Object o)

/**
* @return true 空集合， false 集合中包含元素
*/
boolean isEmpty()

/**
* @return 集合中元素个数
*/
int size()
```


### Map 接口

```
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
     * Associates the specified value with the specified key in this map
     */
    Object put(Object key, Object value);

    /**
     * Removes the mapping for a key from this map if it is present
     */
    Object remove(Object key);


    void clear();

    Set<K> keySet();

    Collection<V> values();

    Set<Map.Entry<K, V>> entrySet();

```