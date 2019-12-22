package com.bi.mt.wwh.leetcode.listnode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-15 下午8:34
 **/
public class RemoveDuplicatesFromSortedList2 {

    /**
     * 利用map 存储元素以及存在的个数，当大于1的时候在新链表中就不必存在即可
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        Map<Integer, Integer> map = new HashMap<>(16);
        ListNode cur = head;

        while (cur != null) {
            if (map.containsKey(cur.val)) {
                Integer value = map.get(cur.val);
                map.put(cur.val,value+1);
            } else {
                map.put(cur.val, 1);
            }
            cur = cur.next;
        }

        cur = head;
        ListNode start = new ListNode(-1);
        ListNode tail = start;

        while (cur != null) {
            if (map.get(cur.val) > 1) {
                cur = cur.next;
            } else if (map.get(cur.val) == 1) {
                tail.next = cur;
                cur = cur.next;
                tail = tail.next;
                tail.next = null;
            }
        }

        return start.next;
    }

    public static void main(String[] args) {

    }
}
