package leetcode;

import leetcode.utils.ListNode;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode listNode = reverseKGroup.reverseKGroup(listNode1, 2);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         *
         * 1. 每k个一组调用反转链表的的方法，返回当点的链表
         *      k个一组，记录当前k个头尾节点
         * 2. 断掉k的链表的后续next
         * 3. 连接之前的头部节点
         *
         *
         */

        ListNode temp = new ListNode(0);

        temp.next = head;
        ListNode pre = temp;
        ListNode end = temp;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode kNext = end.next;
            end.next = null;
            pre.next = reverseListNode(start);

            start.next = kNext;

            pre = start;
            end = pre;

        }


        return temp.next;
    }

    private ListNode reverseListNode(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }


}
