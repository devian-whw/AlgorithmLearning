package com.bj.mt.wwh.leetcode.listnode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-11 上午9:25
 **/
public class ReverseLinkedList {
    /**
     * 头插法
     * 下一个节点插入到头节点的前面
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
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

    /**
     * 双指针迭代
     * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
     * 第二个指针 cur 指向 head，然后不断遍历 cur。
     * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
     * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (null != cur) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;

        }

        return prev;

    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head;

    }

    public static void main(String[] args) {

    }
}
