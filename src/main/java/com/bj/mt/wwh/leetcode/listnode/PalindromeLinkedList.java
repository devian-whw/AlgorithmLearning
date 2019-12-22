package com.bj.mt.wwh.leetcode.listnode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-25 上午11:28
 **/
public class PalindromeLinkedList {
    /**
     * 此题的解法 第一时间想到的是 利用list 存储每个节点，然后前后遍历
     * 判断是否符合回文即可,不符合题目的要求因为时间复杂度为O(n) 空间复杂度为O(1)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        int length = 0;

        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        ListNode pos = head;

        for (int i = 0; i < length / 2; i++) {
            pos = pos.next;
        }

        ListNode temp = pos;
        ListNode mid = reverseList(temp);
        pos.next = null;

        while (mid != null && head != null) {
            if (mid.val != head.val) {
                return false;
            }
            mid = mid.next;
            head = head.next;
        }

        if (mid == null && head == null) {
            return true;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur, start = null;

        while (head != null) {
            cur = head.next;
            head.next = start;
            start = head;
            head = cur;
        }

        return start;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        //ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l4;
//        l3.next = l4;
        l4.next = l5;

        System.out.println(isPalindrome(l1));


    }
}
