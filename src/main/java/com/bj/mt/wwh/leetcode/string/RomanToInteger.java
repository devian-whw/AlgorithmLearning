package com.bj.mt.wwh.leetcode.string;

import java.util.HashMap;
import java.util.Map;


/**
 * @author wangwenhao06@meituan.com
 * @create 2020-01-06 下午11:41
 **/
public class RomanToInteger {

    public static int romanToInt(String s) {
        if (s.length() < 1) {
            return 0;
        }

        final Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }};

        int res = 0;
        for (int i = 0; i < s.length(); ) {
            if ((i + 1) < s.length()) {
                if (map.containsKey(s.substring(i, i + 2))) {
                    res += map.get(s.substring(i, i + 2));
                    i = i + 2;
                    continue;
                }
            }

            if (map.containsKey(s.substring(i, i + 1))) {
                res += map.get(s.substring(i, i + 1));
            }
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }
}
