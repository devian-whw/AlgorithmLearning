package com.bi.mt.wwh.leetcode;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-22 上午10:09
 * 可以用DP来解
 * 我们也可以用DP来解，定义一个二维的DP数组，其中dp[i][j]表示s[0,i)和p[0,j)是否match，
 * 然后有下面三种情况(下面部分摘自这个帖子)：
 * 1.  P[i][j] = P[i - 1][j - 1], if p[j - 1] != '*' && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
 * 2.  P[i][j] = P[i][j - 2], if p[j - 1] == '*' and the pattern repeats for 0 times;
 * 3.  P[i][j] = P[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.'), if p[j - 1] == '*' and the pattern repeats for at least 1 times.
 **/
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        if (p == null) {
            return s == null;
        }

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // p 长度为1的时候，s的长度需要为1且s与p的第一个字符相等，或者p的第一个字符为'.' 匹配任意字符
        if (p.length() == 1) {
            return (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        }

        // p 的长度大于1的时候，判断第二个字符是否为'*',如果不是，则判断s和p第一个是否相等，继续匹配后面的
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) {
                return false;
            }
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }

        // p的第二个字符为'*'
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if(isMatch(s,p.substring(2))){
                // 此时匹配* 前的字符出现0次，判断是否匹配
                return true;
            }
            // s 的首字母匹配，去掉首字母，继续循环。
            s=s.substring(1);
        }

        // 处理*号无法匹配的内容 s="" p="a*"
        return isMatch(s,p.substring(2));
    }

    public static void main(String[] args) {
        String s="ab";
        String  p=".*";
        System.out.println(isMatch(s,p));

    }
}
