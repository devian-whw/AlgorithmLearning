package com.bi.mt.wwh.leetcode;

import java.util.Arrays;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-30 下午5:34
 **/
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            throw new IllegalArgumentException("parameter is wrong");
        }

        if (nums1.length == 0 || nums1 == null) {
            getMedian(nums2);
        }

        if (nums2.length == 0 || nums2 == null) {
            return getMedian(nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int[] nums = new int[m + n];

        double mid = 0.0;
        int start = 0;
        for (int i = 0; i < m; i++) {
            nums[start++] = nums1[i];
        }

        for (int j = 0; j < n; j++) {
            nums[start++] = nums2[j];
        }

        Arrays.sort(nums);
        return getMedian(nums);
    }

    private static void print(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }

    private static double getMedian(int[] nums) {
        double mid;
        int m = nums.length;
        int pos = m / 2;
        if (m % 2 == 0) {
            mid = (nums[pos] + nums[pos - 1]) / 2.0;
        } else {
            mid = nums[pos] / 1.0;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
