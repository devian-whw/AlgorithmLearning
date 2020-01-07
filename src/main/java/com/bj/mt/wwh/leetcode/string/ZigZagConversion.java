package com.bj.mt.wwh.leetcode.string;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-12-29 下午2:49
 **/
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        char[][] strArray = new char[numRows][s.length()];
        // 把字符串填写到二维数组中 数字游戏
        int rows = 0, cols = 0;

        // 是否向上走 行数增加 行 数字变化123212321 /1234321234321
        boolean up = true;

        for (int cnt = 1; cnt <= s.length(); cnt++) {
            if (cnt == 1) {
                strArray[0][cols] = s.charAt(cnt - 1);
                continue;
            }

            if (rows == numRows - 1) {
                up = false;
            }
            if (up) {
                rows++;
            } else {
                rows--;
                cols++;
                if (rows < 0) {
                    rows = 1;
                    up = true;
                    cols = cols - 1;
                }
            }
            strArray[rows][cols] = s.charAt(cnt - 1);
        }

        StringBuilder sb = new StringBuilder();
        // 将二维数组中的字符串输出即可
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                if (strArray[i][j] != 0) {
                    sb.append(strArray[i][j]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}
