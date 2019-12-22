package com.bi.mt.wwh.leetcode.listnode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-30 下午7:35
 * 1、插入法 进行排序
 * 2、遍历链表 将所有的值全都存进数组然后对数组排序 然后改变值即可.
 **/
public class SortList {

    private static void insertListNode(ListNode result, ListNode node) {
        ListNode p = result.next;

        if (p == null) {
            p = node;
            result.next = p;
            return;
        }

        // 用两个指针 一个前指针一个后指针 大于前指针，小于后指针做插入即可。
        while (p.next != null) {
            if (p.val > node.val) {
                node.next = p;
                result.next = node;
                break;
            } else if (p.val <= node.val) {
                if (p.next.val >= node.val) {
                    node.next = p.next;
                    p.next = node;
                    break;
                } else {
                    p = p.next;
                }
            }
        }

        if (p.next == null) {
            if (p.val > node.val) {
                node.next = p;
                result.next = node;
            } else {
                p.next = node;
            }
        }
    }

    public static ListNode sortList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            insertListNode(result, node);
            cur = cur.next;
        }

        return result.next;
    }

    public static ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        ListNode cur = head;

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        Collections.sort(list);

        int pos = 0;
        cur = head;
        while (head != null) {
            head.val = list.get(pos);
            pos++;
            head = head.next;
        }

        return cur;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(-1);
        n4.next = n5;
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        print(n1);
        System.out.println();
        ListNode h = sortList2(n1);
        print(h);

    }
}
