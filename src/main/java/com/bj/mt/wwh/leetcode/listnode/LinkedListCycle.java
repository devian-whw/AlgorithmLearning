package com.bj.mt.wwh.leetcode.listnode;


import java.util.HashSet;
import java.util.Set;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-15 下午2:47
 **/
public class LinkedListCycle {
    /**
     * 1、快慢指针判断是否有环
     * 2、使用HashSet存入值的唯一性来进行判断
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        System.out.println(hasCycle(l1));

    }
}
