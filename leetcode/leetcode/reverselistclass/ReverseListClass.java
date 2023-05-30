package leetcode.reverselistclass;

/**
 * @Author: lvxiaoyi
 * @Description: 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @DateTime: 2023/5/29 16:50
 */

public class ReverseListClass {
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


        ReverseListClass reverseListClass = new ReverseListClass();
        ListNode listNode = reverseListClass.reverseList(listNode1);
        System.out.println(listNode);

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}

