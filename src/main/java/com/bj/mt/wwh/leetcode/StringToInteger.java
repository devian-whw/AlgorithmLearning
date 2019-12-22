package com.bj.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-07 下午10:41
 **/
public class StringToInteger {

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int res = 0;
        int sign = 1;
        int start = 0;
        // " "测试字符只有一个空的时候，start < str.length() 回出现越界的情况
        while (str.charAt(start) == ' ' && start < str.length()-1) {
            start++;
        }

        System.out.println("start:"+start);
        if (str.charAt(start) == '-' || str.charAt(start) == '+') {
            sign = str.charAt(start) == '-' ? -1 : 1;
            start++;
        }


        for (int i = start; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num < 0 || num > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < num) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = 10 * res + num;
        }

        return sign * res;
    }

    public static void main(String[] args) {
        String t=" ";
        System.out.println(t.length());
        System.out.println(myAtoi(t));

    }
}
