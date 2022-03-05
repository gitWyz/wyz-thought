package linkedlist;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * @author wangyz
 * @version 1.0
 * @date 2021/4/11
 */
public class L_141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L_141_环形链表 l = new L_141_环形链表();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);
        System.out.println(l.hasCycle(listNode));
        System.out.println(listNode);
    }
}
