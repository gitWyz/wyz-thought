package list;

/**
 * @author wangyz
 * @version 1.0
 * @date 2021/4/5
 */
public interface List<E> {
    static final int ELEMENT_NOT_FOUND = -1;
    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加元素到尾部
     * @param element
     */
    void add(E element);

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    E set(int index, E element);

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 查看元素在此列表首次出现的索引，如果没有返回-1
     * @param element
     * @return
     */
    int indexOf(E element);
}
