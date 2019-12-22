package com.bi.mt.wwh.leetcode;

import java.util.Stack;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-09 下午5:43
 **/
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.peek() != '(') {
                    return false;
                }
                if (ch == '}' && stack.peek() != '{') {
                    return false;
                }
                if (ch == ']' && stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test="()[]{}";
        String test1="(]";
        System.out.println(isValid(test1));

    }
}
