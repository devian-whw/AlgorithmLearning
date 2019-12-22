package com.bj.mt.wwh.leetcode.listnode;


/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-15 上午11:34
 **/
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = new ListNode(0);
        ListNode cur = head;
        ListNode nex = head.next;
        head = start;

        while (nex != null) {

            if (nex != null) {
                head.next = nex;
                nex = nex.next;
                head = head.next;
                head.next = null;
            }

            head.next = cur;
            head = head.next;
            head.next = null;

            if (nex == null) {
                break;
            } else {
                cur = nex;
                nex = nex.next;
            }
        }

        if (cur != null) {
            head.next = cur;
            cur.next=null;
        }
        return start.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if( head == null || head.next == null) return head;

        head.next.next = swapPairs1(head.next.next);

        ListNode newCur = head.next;
        head.next = newCur.next;
        newCur.next = head;

        return newCur;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        print(l1);
        System.out.println();
        print(swapPairs(l1));
    }
}
