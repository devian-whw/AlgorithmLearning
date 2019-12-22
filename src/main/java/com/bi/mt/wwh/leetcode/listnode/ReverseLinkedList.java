package com.bi.mt.wwh.leetcode.listnode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-11 上午9:25
 **/
public class ReverseLinkedList {
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur,start = null;

        while (head != null) {
            cur = head.next;
            head.next = start;
            start = head;
            head = cur;
        }

        return start;

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head;

    }

    public static void main(String[] args) {

    }
}
