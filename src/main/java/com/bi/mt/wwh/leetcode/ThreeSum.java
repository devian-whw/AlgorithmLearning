package com.bi.mt.wwh.leetcode;

import java.util.*;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-29 上午10:03
 **/
public class ThreeSum {

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
