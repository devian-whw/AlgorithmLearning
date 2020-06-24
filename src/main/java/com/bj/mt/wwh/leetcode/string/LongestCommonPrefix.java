package com.bj.mt.wwh.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wangwenhao06@meituan.com
 * @create 2020-01-07 下午11:32
 * leetCode 14 最长公共前缀
 **/
public class LongestCommonPrefix {

    /**
     * 字符串两两比较，从第一个字符开始找到相同的公共前缀
     * 容易错的地方是：当找到两个不等的字符串直接截取前缀，
     * 但是有一种情况是 "aa","a" 所以应该截取比较短的，
     * 或者将字符串数组排序从小到大开始比较
     * 横向比较
     * O（m*n）
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    // 错误的写法，跑不过测试用例，"aaa","aa"，比较不会进来
                    //  prefix = prefix.substring(0, j);
                    System.out.println("prefix:" + prefix);
                    break;
                }
            }
            prefix = prefix.substring(0, j);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String test = "test";
        System.out.println("test:" + test.substring(0, 0));
        String[] strs = new String[]{"aaa", "aa", "a"};
        System.out.println("lcp:" + longestCommonPrefix(strs));
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Arrays.stream(strs).forEach(System.out::println);
    }
}
