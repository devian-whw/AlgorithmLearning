package com.bi.mt.wwh.leetcode.listnode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-28 下午5:44
 **/
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int sum = l1.val + l2.val;
        int carry = sum / 10;
        int remain = sum % 10;
        ListNode res = new ListNode(remain);
        ListNode temp = res;
        l1 = l1.next;
        l2 = l2.next;


        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            remain = sum % 10;
            ListNode tn = new ListNode(remain);
            temp.next = tn;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            remain = sum % 10;
            ListNode tn = new ListNode(remain);
            temp.next = tn;
            temp = temp.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            remain = sum % 10;
            ListNode tn = new ListNode(remain);
            temp.next = tn;
            temp = temp.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return res;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode temp = res;

        while (l1 != null || l2 != null) {
            int t1 = l1 != null ? l1.val : 0;
            int t2 = l2 != null ? l2.val : 0;
            int sum = t1 + t2 + carry;
            carry = sum / 10;
            int remain = sum % 10;
            ListNode tn = new ListNode(remain);
            temp.next = tn;
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return res.next;
    }

    static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "-->");
            l = l.next;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode t1 = l1;
        ListNode t2 = l2;

        t1.next = new ListNode(3);
        t1 = t1.next;
        t2.next = new ListNode(7);
        t2 = t2.next;

        t1.next = new ListNode(4);
        t1 = t1.next;
        t2.next = new ListNode(5);
        t2 = t2.next;

        t1.next = new ListNode(5);
        t1 = t1.next;
        t2.next = new ListNode(9);
        t2 = t2.next;

        t2.next = new ListNode(9);
        t2 = t2.next;


        print(l1);
        System.out.println();

        print(l2);
        System.out.println();

        print(addTwoNumbers1(l1, l2));

    }
}
