package com.bi.mt.wwh.leetcode;

import java.util.Stack;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-27 下午4:03
 **/
public class MinStack {

    private Stack<Integer> stack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min)) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
    }

}
