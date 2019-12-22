package com.bj.mt.wwh.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-30 上午10:21
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * https://blog.csdn.net/lanyu_01/article/details/81062232#3longest-substring-without-repeating-characters
 * https://www.cnblogs.com/K-artorias/p/7665604.html
 * 滑动窗口法
 **/
public class LongestSubstring {

    /**
     * 滑动窗口的解法
     * 解题思路：
     *      * 利用滑动窗口[i,j)表示从位置i到j的子字符串str，用集合Set表示str中的字符集合，用maxL表示该字符串
     *      * 长度，进行以下操作：
     *      * 1)先滑动窗口的右部边界，即j+1，判断str中是否出现重复字符：
     *      *          若果未出现，则更新Set和maxL，并继续1)步骤
     *      *          如果出现重复步骤，则表示当前子串已不能再扩大长度，故执行2)步骤
     *      * 2)滑动窗口的左部边界，接i+1，同时判断str中是否包含重复字符
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans = Math.max(ans, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isStringRepeated(temp)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private static boolean isStringRepeated(String temp) {
        Set<Character> set = new HashSet<>();
        for (char ch : temp.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        if (set.size() == temp.length()) {
            return true;
        }
        return false;
    }

    /**
     * https://blog.csdn.net/m0_37862405/article/details/80369128
     * @param string
     * @return
     */
    private static int findLongestSubstringLength(String string)
    {
        if (string == null || string.equals("")) return 0;
        int maxLength = 0;
        int curLength = 0;
        int[] positions = new int[26];
        for (int i = 0; i < positions.length; i++)
        {
            //初始化为-1，负数表示没出现过
            positions[i] = -1;
        }
        for (int i = 0; i < string.length(); i++)
        {
            int curChar = string.charAt(i) - 'a';
            int prePosition = positions[curChar];
            //当前字符与它上次出现位置之间的距离
            int distance = i - prePosition;
            //当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
            if (prePosition < 0 || distance > curLength)
            {
                curLength++;
            } else
            {
                //更新最长非重复子字符串的长度
                if (curLength > maxLength)
                {
                    maxLength = curLength;
                }
                curLength = distance;
            }
            // 更新字符出现的位置
            positions[curChar] = i;
        }
        if (curLength > maxLength)
        {
            maxLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String test = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(test));
    }

}
