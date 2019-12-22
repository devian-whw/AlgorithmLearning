package com.bi.mt.wwh.leetcode.listnode;


/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-30 下午7:09
 **/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode node = new ListNode(0);
        ListNode head = node;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            } else {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }


        while (l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }

        while (l2 != null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
