package com.bj.mt.wwh.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-06-26 下午3:31
 * LeetCode 137：某个元素只出现一次以外，其余每个元素均出现了三次
 * 有限自动状态机：
 * https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
 * LeetCode 136. 只出现一次的数字
 * LeetCode 面试题56 - I. 数组中数字出现的次数
 * LeetCode 面试题 17.19. 消失的两个数字
 **/
public class SingleNumberII {
    /**
     * 利用map 统计出现的次数
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (null == nums || nums.length <= 0) {
            throw new IllegalArgumentException("参数不合法!");
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("参数不合法!");
    }

    /**
     * HashSet
     * 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
     * c是我们要找的值
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, sumSet = 0;
        for (int n : nums) {
            sum += n;
            set.add(n);
        }

        for (Integer item : set) {
            sumSet += item;
        }
        return (3 * sumSet - sum) / 2;
    }

    /**
     * 某个位置的数字出现奇数次时，该位的掩码才不为 0
     * 0⊕x=x,x⊕x=0
     * 思路：对于出现三次的数字，各二进制位出现的次数都是3的倍数
     * 1.统计所有数字的各二进制位中 1 的出现次数，并对 33 求余，结果则为只出现一次的数字。
     * 2.对于每一位而言，所有位置1的个数存在三种状态0,1,2 表示三种状态只能用两个位来表示00,01,10,00,01,10
     * 3.根据有限状态机推导出计算
     * 最后是计算每一个bit 上1的个数，是由ones 统计的
     * 通用解法：https://leetcode-cn.com/problems/single-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--31/
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    /**
     * 1.位运算求解此题;
     * 2.如果把所有出现三次的数字的二进制表示的每一位加起来,那么每一位都能被3整除;
     * 3.如果某一位的和能被3整除,那么只出现一次数字的二进制位中对应的那一位就是0,否则就是1;
     * 4.完结。
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        if (nums == null || nums.length <= 0)
            throw new RuntimeException("数组不合法");

        int[] bits = new int[32];

        for (int j = 0; j < bits.length; j++) {
            // 每一位数字对应的0或1加起来
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i] >> j;
                bits[j] += (num & 1);
            }
        }

        int result = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            result <<= 1;
            result += bits[i] % 3;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }
}
