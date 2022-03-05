package linkedlist;

/**
 * @author wangyz
 * @version 1.0
 * @date 2021/4/11
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode[" +
                "val=" + val +
                ", next=" + next +
                ']';
    }
}
