package com.bj.mt.wwh.leetcode;

import java.util.Arrays;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-06-24 下午10:19
 **/
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (null == nums || nums.length < 3) {
            throw new IllegalArgumentException("参数不合法");
        }
        Arrays.sort(nums);
        int len = nums.length;
        // int 最大值
        int difference = 2147483647;
        int result = 0;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int temp = Math.abs(sum - target);
                if (temp < difference) {
                    difference = temp;
                    result = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 1, -3};
        System.out.println(threeSumClosest(nums, 1));
    }
}
