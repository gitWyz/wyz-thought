package list.linkedlist;

import list.AbstractList;

/**
 * @author wangyz
 * @version 1.0
 * @date 2021/4/11
 */
public class DoublyLinkedList<E> extends AbstractList<E> {
    Node<E> first;
    Node<E> last;

    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 清除所有元素
     */
    @Override
    public void clear() {
        size = 0;
        first = last = null;
    }

    /**
     * 获取index位置对应的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);
        if (index < size >> 1) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = first.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = last.prev;
            }
            return node;
        }
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(E element) {
        this.add(size, element);
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(element, oldLast, null);
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> currentNode = new Node<>(element, prevNode, nextNode);
            nextNode.prev = currentNode;
            if (prevNode == null) {
                first = currentNode;
            } else {
                prevNode.next = currentNode;
            }
        }
        size++;

    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;
        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
        }
        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
        }
        size--;
        return node.element;
    }

    /**
     * 查看元素在此列表首次出现的索引，如果没有返回-1
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(node.element);

            node = node.next;
        }
        string.append("]");
        return string.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);

        //System.out.println(doublyLinkedList.remove(2));
        //System.out.println(doublyLinkedList.get(2));
        //System.out.println(doublyLinkedList.set(2, 22));
        //doublyLinkedList.clear();
        doublyLinkedList.add(2, 22);
        System.out.println(doublyLinkedList);
    }
}
