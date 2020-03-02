package com.bj.mt.wwh.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-03-01 下午10:34
 **/
public class ImplementStackUsingQueues {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.offer(queue.remove());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack=new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
