package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-27 上午10:35
 **/
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) {
            return 0;
        }

        int res = 0;
        int buy = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(prices[i], buy);
            res = Math.max(res, prices[i] - buy);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));

    }
}
