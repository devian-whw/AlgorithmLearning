package com.bj.mt.wwh.leetcode;

import java.util.ArrayList;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-27 下午12:34
 * LeetCode 136 异或
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }


    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

    }
}
