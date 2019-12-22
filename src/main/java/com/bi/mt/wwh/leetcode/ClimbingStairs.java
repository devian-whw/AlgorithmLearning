package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-24 上午11:36
 * 爬楼梯问题是一个斐波那契数列的题目
 **/
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs1(int n) {
        int t1 = 1;
        int t2 = 2;
        if (n == 1) {
            return t1;
        }
        if (n == 2) {
            return t2;
        }

        int res = 0;
        for (int pos = 3; pos <= n; pos++) {
              res=t1+t2;
              t1=t2;
              t2=res;
        }

        return res;
    }

    /**
     *假设一个楼梯有 N 阶台阶，人每次最多可以跨 M 阶，求总共的爬楼梯方案数。
     * @param n 总的台阶数
     * @param m 一次可以走的最大楼梯阶数
     * @return
     */
    private static int getStepNum(int n, int m) {
        int sumStep = 0;
        //总台阶数为0时，终止递归循环
        if (n == 0) {
            return 1;
        }
        if (n >= m) {
            //如果n大于每步最大台阶数，则设置第一步为m之内的一个台阶数，然后递归循环
            for (int i = 1; i <= m; i++) {
                sumStep += getStepNum(n - i, m);
            }
        }
        //如果n小于m，则将一步最大台阶数缩小为n，重新递归
        else {
            sumStep = getStepNum(n, n);
        }
        return sumStep;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
    }
}
