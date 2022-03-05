package linkedlist;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @author wangyz
 * @version 1.0
 * @date 2021/4/11
 */
public class L_206_反转链表 {

    /**
     * javadoc reverseList
     * @apiNote 方法一： 递归反转链表
     *
     * @param head
     * @return com.wyz.leetcode.linkedlist.ListNode
     * @author wangyz
     * @date 2021-04-11 16:02:00
     */
    public ListNode reverseList1(ListNode head) {
//        System.out.println("head=" + head);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        //System.out.println("内部：" + newHead);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * javadoc reverseList2
     * @apiNote 方法一： 迭代反转链表
     *
     * @param head
     * @return com.wyz.leetcode.linkedlist.ListNode
     * @author wangyz
     * @date 2021-04-11 20:59:00
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
            System.out.println(newHead);
        }
        return newHead;
    }

    public static void main(String[] args) {
        L_206_反转链表 l = new L_206_反转链表();
        // 下面3行模拟链表添加5个节点: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        //l.reverseList1(listNode);
        //System.out.println(listNode);
        //System.out.println("方法一：反转结果："+l.reverseList1(listNode));
        System.out.println("方法二：反转结果："+l.reverseList2(listNode));
    }
}
