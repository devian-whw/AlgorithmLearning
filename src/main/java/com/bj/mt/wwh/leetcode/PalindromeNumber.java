package com.bj.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-07 上午11:10
 **/
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int start=x;
        int res = 0;
        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;
            res = res * 10 + remainder;
        }
        System.out.println(res);
        if (res == start) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int t=10;
        System.out.println(isPalindrome(t));

    }
}
