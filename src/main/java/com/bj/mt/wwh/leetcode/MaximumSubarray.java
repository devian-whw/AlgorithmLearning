package com.bj.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-24 上午10:45
 **/
public class MaximumSubarray {

    /**
     * 双重循环取连续数组累加判断最大值进行返回即可
     * 超时最容易想到的办法 但是超时
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = 0;
                for (int pos = i; pos <= j; pos++) {
                    temp += nums[pos];
                }
                max = Math.max(temp, max);
            }
        }

        return max;
    }

    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            max = Math.max(max, cur);
        }

        return max;
    }

    /**
     * Divide and Conquer Approach 分治法来进行求解
     * 把数组一分为二，分别找出左边和右边的最大子数组之和，然后还要从中间开始向左右分别扫描，
     * 求出的最大值分别和左右两边得出的最大值相比较取最大的那一个
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }


    public static void main(String[] args) {
        //System.out.println("i: " + i + " cur:" + cur + " max: " + max);
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{-2,-1};
        int[] nums = new int[]{1, 2, 3, 4, -1, -2, -3, -4, 7, 8, 9, 10};
        System.out.println(maxSubArray1(nums));

    }
}
