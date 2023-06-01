package leetcode;

import leetcode.utils.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(listNode1, listNode4);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /**
         *
         * 给出的两个链表均为有序的链表，记录两个链表的当前值，遍历两个链表
         *
         *
         */

        ListNode head = new ListNode(0);
        ListNode pre = head;

        while (list1 != null || list2 != null) {
            Integer nodeValue1 = null;
            if (list1 == null) {
                pre.next = list2;
                return head.next;
            }
            if (list2 == null) {
                pre.next = list1;
                return head.next;
            }

            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;

        }
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        /**
         *
         * 给出的两个链表均为有序的链表，记录两个链表的当前值，遍历两个链表
         *
         *
         */

        ListNode head = new ListNode(0);
        ListNode pre = head;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;

        }
        pre.next = list1 == null? list2:list1;
        return head.next;
    }
}
