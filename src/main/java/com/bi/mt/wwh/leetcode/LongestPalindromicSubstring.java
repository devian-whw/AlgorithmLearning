package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-06 上午11:29
 **/
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int max = 0;
        String smax = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp)) {
                    if (j - i > max) {
                        smax = temp;
                        max = j - i;
                    }
                }
            }
        }

        return smax;
    }

    /**
     * 最长回文子串
     * 如果一个串是回文串，那么向左右两边各拓展一位，如果首尾字符相等，则新的串也是回文串；
     * 故选取中心点，往两边进行拓展，直到不是回文串为止；
     * 从中心拓展时分别考虑子串长度为奇、偶两种情况，如a->xax,aa->xaax；
     * 往两边拓展的时候需要考虑是否越界；
     * 用一个变量记录下遍历到回文子串的最大size，以及开始位置
     */
    public String longestPalindrome1(String s) {
        int maxSize = 0, startPos = 0;
        for (int i = 0; i < s.length(); i++) {
            // 子串长度为奇数
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // 检查最大长度是否需要更新；
                if (right - left + 1 > maxSize) {
                    maxSize = right - left + 1;
                    startPos = left;
                }

                left--;
                right++;
            }

            // 子串长度为偶数情况
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // 检查最大长度是否需要更新；
                if (right - left + 1 > maxSize) {
                    maxSize = right - left + 1;
                    startPos = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(startPos, startPos + maxSize);
    }


    /**
     * 回文判断还有个办法 逆序字符串 如果与原来的相等 则是回文
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length() / 2;

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String t1 = "babad";
        String t2 = "abba";
        System.out.println(longestPalindrome(t1));
    }
}
