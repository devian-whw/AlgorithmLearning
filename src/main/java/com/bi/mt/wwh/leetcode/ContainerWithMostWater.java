package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-22 上午11:19
 **/
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        if (height.length < 2) {
            return maxArea;
        }

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    /**
     * 定义i和j两个指针分别指向数组的左右两端，然后两个指针向中间搜索，每移动一次算一个值和结果比较取较大的，
     * 容器装水量的算法是找出左右两个边缘中较小的那个乘以两边缘的距离
     * 简单的理解:
     * 左端为L,右端为R,则体积为Math.min(A[L],A[R])*(r-l)
     * 如果 L < R,向右移动L, 因为此时容器的高度是L,R-L 即宽度减小,体积必然减小,
     * 所以可以忽略所有其他的当L为左端边界的情况.R的移动同理.
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        if (height.length < 2) {
            return maxArea;
        }

        int head = 0;
        int tail = height.length - 1;
        while (head < tail) {
            maxArea = Math.max(maxArea, Math.min(height[head], height[tail]) * (tail - head));
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(array));

    }
}
