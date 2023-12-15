package leetcode;

import leetcode.utils.ListNode;

/**
 * @Author: lvxiaoyi
 * @Description: 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * @DateTime: 2023/12/15 22:27
 */

public class Leetcode141_hasCycle {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        Leetcode141_hasCycle leetcode141_hasCycle = new Leetcode141_hasCycle();

        System.out.println(leetcode141_hasCycle.hasCycle(listNode1));

    }

    /**
     * @Author: lvxiaoyi
     * @Description: 判断链表是否有环，使用快慢指针，快指针每次走两步，慢指针每次走一步
     * @DateTime: 2023/12/15 22:32
     */

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

}
