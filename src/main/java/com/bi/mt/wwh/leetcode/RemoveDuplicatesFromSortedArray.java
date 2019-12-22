package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-22 下午6:05
 **/
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int slow = 0, fast = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        RemoveElement.printArray(nums,slow+1);
        System.out.println();
        return slow+1;


    }

    public static void main(String[] args) {
        int [] nums=new int[] {0,0,1,1,1,2,2,3,3,4};
        RemoveElement.printArray(nums,nums.length);
        System.out.println();
        System.out.println(removeDuplicates(nums));

    }
}
