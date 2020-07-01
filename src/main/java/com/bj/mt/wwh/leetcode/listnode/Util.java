package com.bj.mt.wwh.leetcode.listnode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-16 上午10:33
 * LeetCode Template:https://greyireland.gitbook.io/algorithm-pattern/shu-ju-jie-gou-pian/linked_list
 **/
public class Util {
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }
}
