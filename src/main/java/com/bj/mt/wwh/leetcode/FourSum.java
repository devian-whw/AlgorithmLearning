package com.bj.mt.wwh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-06-24 下午7:37
 * LeetCode.18
 **/
public class FourSum {
    /**
     * 在3Sum 的基础上添加一次循环即可
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int left = b + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[a] + nums[b] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> subResult = new ArrayList<>();
                        subResult.add(nums[a]);
                        subResult.add(nums[b]);
                        subResult.add(nums[left]);
                        subResult.add(nums[right]);
                        result.add(subResult);
                        // 去掉重复结果
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }

                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }

                        left++;
                        right--;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
