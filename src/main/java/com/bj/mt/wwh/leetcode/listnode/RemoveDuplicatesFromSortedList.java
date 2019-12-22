package com.bj.mt.wwh.leetcode.listnode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-15 下午8:58
 **/
public class RemoveDuplicatesFromSortedList {

    /**
     * 利用list存储唯一的元素,重写contains方法判断元素是否存在于list当中
     * set 存储ListNode 的节点时候，如果需要判断唯一性需要重写equals 和 hashCode 方法
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        List<ListNode> list = new LinkedList<>();
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            if (!elementInList(list, temp)) {
                list.add(temp);
            }
        }

        ListNode start = new ListNode(0);
        ListNode tail = start;

        for (ListNode node : list) {
            tail.next = node;
            tail = tail.next;
            tail.next = null;
        }

        return start.next;
    }

    private static boolean elementInList(List<ListNode> list, ListNode temp) {
        for (ListNode node : list) {
            if (node.val == temp.val) {
                return true;
            }
        }
        return false;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Util.print(l1);
        System.out.println();
        Util.print(deleteDuplicates(l1));

    }
}
