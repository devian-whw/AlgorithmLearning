package com.bj.mt.wwh.leetcode;

import java.util.Date;
import java.util.Stack;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-04 下午10:28
 * https://www.cnblogs.com/hantalk/p/8734511.html
 **/
public class BasicCalculator {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = "(" + s + ")";
        Stack<Character> operator = new Stack<>();
        Stack<Integer> number = new Stack<>();
        // s.replace("\\s+","");

        int temp = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }

            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                temp = s.charAt(i) - '0';
                while (i != (s.length() - 1) && (s.charAt(i + 1) - '0') >= 0 && (s.charAt(i + 1) - '0') <= 9) {
                    i++;
                    temp = temp * 10 + s.charAt(i) - '0';
                }
                number.push(temp);
            }

            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
                operator.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                int num = 0;
                while (operator.peek() != '(') {
                    int a = number.pop();
                    char ch = operator.pop();
                    switch (ch) {
                        case '+':
                            num = num + a;
                            break;
                        case '-':
                            num = num - a;
                            break;
                        default:
                            break;
                    }
                }
                num += number.pop();
                number.push(num);
                operator.pop();
            }
        }
        return number.pop();
    }

    public static void main(String[] args) {
        String s="\"(1+(4+5+2)-3)+(6+8)\"";
        System.out.println(calculate(s));
        System.out.println(new Date());
    }
}
