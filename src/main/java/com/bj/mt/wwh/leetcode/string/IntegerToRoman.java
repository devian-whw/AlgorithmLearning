package com.bj.mt.wwh.leetcode.string;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-01-06 下午10:40
 **/
public class IntegerToRoman {

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "parameter is wrong!";
        }

        // 定义一个字典
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();

        // 用这些字段去枚举所有的值
        for (int i = 0; i < values.length; i++) {
            int quotient = num / values[i];
            int remainder = num % values[i];
            if (quotient == 0) {
                continue;
            } else {
                for (int j = 0; j < quotient; j++) {
                    res.append(symbol[i]);
                }
            }

            if (remainder == 0) {
                break;
            } else {
                num = remainder;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
