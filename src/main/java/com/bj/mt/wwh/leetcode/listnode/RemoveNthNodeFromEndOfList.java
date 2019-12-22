package com.bj.mt.wwh.leetcode.listnode;



/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-29 下午6:26
 **/
public class RemoveNthNodeFromEndOfList {

    /**
     * 双指针 提前走N步长
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode back = head;

        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }

        if (pre == null) {
            return head.next;
        }

        while (pre.next != null) {
            pre = pre.next;
            back = back.next;
        }

        back.next = back.next.next;

        return head;
    }

    public static void main(String[] args) {

    }
}
