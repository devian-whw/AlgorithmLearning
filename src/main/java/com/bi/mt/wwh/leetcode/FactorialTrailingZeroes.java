package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-06-02 下午1:01
 **/
public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int res=0;
        while (n>0){
            res+=n/5;
            n=n/5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));

    }
}
