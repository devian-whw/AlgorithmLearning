package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-07 上午10:51
 **/
public class ReverseInteger {

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;
            res = res * 10 + remainder;
            if(res>(Math.pow(2,31)-1) || res<-2147483648 ){
                return 0;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int t = 1534236469;
        System.out.println(reverse(t));
    }
}
