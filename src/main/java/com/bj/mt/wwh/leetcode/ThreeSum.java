package com.bj.mt.wwh.leetcode;

import java.util.*;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-29 上午10:03
 **/
public class ThreeSum {

    /**
     * 双重循环加hashMap
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int length = nums.length;
        Map<Integer, Integer> m1 = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            m1.put(nums[i], i);
        }
        System.out.println(m1);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (m1.containsKey(-sum) && m1.get(-sum) != i && m1.get(-sum) != j) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[m1.get(-sum)]);
                    Collections.sort(temp);
                    result.add(temp);
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 排序加双指针
     * 1.特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     * 2.对数组进行排序。
     * 3.遍历排序后数组：
     * i:若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
     * ii:对于重复元素：跳过，避免出现重复解
     * iii:令左指针 L=i+1L右指针 R=n-1，当 L<R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0,执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R移到下一位置，寻找新的解
     * 若和大于 0，说明 nums[R]太大，R 左移
     * 若和小于 0，说明 nums[L] 太小，L 右移
     *
     * @param nums
     */

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int cur = nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(cur);
                    subResult.add(nums[left]);
                    subResult.add(nums[right]);
                    result.add(subResult);
                    // 去除左指针的重复值
                    while (left < right && nums[left + 1] == nums[left]) {
                        ++left;
                    }
                    // 去除右指针的重复值
                    while (left < right && nums[right - 1] == nums[right]) {
                        --right;
                    }
                    ++left;
                    --right;
                } else if (temp < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return result;
    }

    public static void print(List<List<Integer>> result) {
        for (List<Integer> list : result) {
            list.forEach(item -> {
                System.out.print(item + " ");
            });
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        print(threeSum(nums));

    }
}
