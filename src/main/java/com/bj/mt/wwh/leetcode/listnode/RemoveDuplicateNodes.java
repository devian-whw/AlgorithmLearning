package com.bj.mt.wwh.leetcode.listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-06-26 下午1:40
 * LeetCode 1591
 **/
public class RemoveDuplicateNodes {
    /**
     * 利用list/set 存储判断是否有重复的,然后向前走即可
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (null == head) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (set.contains(cur.val)) {
                cur = cur.next;
                prev.next = cur;
            } else {
                set.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 构造新链表，判断下一个节点在新链表中是否存在
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes1(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode cur = head.next;
        ListNode tail = head;
        ListNode start = tail;
        tail.next = null;
        while (cur != null) {
            if (isExistSameNode(start, cur)) {
                cur = cur.next;
            } else {
                // 断链的时候，需要cur 先向前走，tail.next=null,不然cur 的next 也会为空
                tail.next = cur;
                tail = tail.next;
                cur = cur.next;
                tail.next = null;
            }
        }
        return start;
    }

    private static boolean isExistSameNode(ListNode head, ListNode node) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == node.val) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        Util.print(n1);
        System.out.println();
        Util.print(removeDuplicateNodes1(n1));
    }
}
