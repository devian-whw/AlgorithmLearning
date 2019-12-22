package com.bj.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-22 下午12:22
 **/
public class RemoveElement {

    /**
     * 移除数组中的的指定元素
     * 找不到不符合条件的元素从数组开始为止复制一份即可.
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static int removeElement1(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int pos = 0;
        int len = nums.length;
        while (pos < len) {
            if (nums[pos] == val) {
                nums[pos] = nums[len - 1];
                len--;
            } else {
                pos++;
            }
        }
        printArray(nums, len);
        System.out.println();
        return len;
    }


    public static void printArray(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        printArray(nums, nums.length);
        System.out.println();
        System.out.println(removeElement1(nums, 2));

    }
}
