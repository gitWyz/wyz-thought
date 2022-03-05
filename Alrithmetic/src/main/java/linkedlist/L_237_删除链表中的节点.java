package linkedlist;

/**
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 *
 * @author wangyz
 * @version 1.0
 * @date 2021/4/11
 */
public class L_237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        L_237_删除链表中的节点 l = new L_237_删除链表中的节点();
        // 下面3行模拟链表添加4个节点 4 -> 5 -> 1 -> 9 -> null
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        // 删除5这个节点
        // 注意：不能删除最后一个节点（题目要求）
        l.deleteNode(listNode.next);
        System.out.println(listNode);
    }
}
