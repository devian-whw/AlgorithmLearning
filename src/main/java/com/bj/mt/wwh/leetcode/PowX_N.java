package com.bj.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-13 下午6:27
 **/
public class PowX_N {

    public static void main(String[] args) {
       /* System.out.println(myPow(2.00000, 10));
        System.out.println(Math.pow(2.00000, 10));
        int n = 2147483647;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(n);*/

        int test = -2147483648;
        System.out.println(Math.abs(test));
        System.out.println(Math.abs(test) > Integer.MAX_VALUE);
    }

    public static double myPow1(double x, int n) {
        double res = x;

        if (n == 0) {
            return 1;
        } else if (n > 0) {
            for (int i = 1; i < n; i++) {
                res *= x;
            }
        } else {
            for (int i = 1; i < -n; i++) {
                res *= x;
            }
            res = 1 / res;
        }
        return res;
    }

    public static double myPow(double x, int n) {
        int flag = -2147483648;
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            if (flag == n) {
                double s = 1 / myPow(x, -(n + 1));
                return s * (1 / x);
            } else {
                return 1 / myPow(x, -n);
            }
        } else {
            double res = x;
            for (int i = n - 1; i > 0; i--) {
                if (i % 2 == 0) {
                    x = x * x;
                    i = i / 2;
                }
                res = res * x;
            }
            return res;
        }
    }

    public static double myPow3(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }


}
