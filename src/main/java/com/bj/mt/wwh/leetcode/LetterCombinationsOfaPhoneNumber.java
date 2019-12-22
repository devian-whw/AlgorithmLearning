package com.bj.mt.wwh.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-14 下午4:59
 **/
public class LetterCombinationsOfaPhoneNumber {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    /**
     * public List<String> letterCombinations(String digits) {
     *         String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
     *         List<String> res = new ArrayList<>();
     *         if(digits == null || digits.length() == 0) return res;
     *         backtrack(res, map, digits, 0, "");
     *         return res;
     *     }
     *
     *     public void backtrack(List<String> res, String[] map, String digits, int start, String temp){
     *         if(start == digits.length()){
     *             res.add(temp);
     *             return;
     *         }
     *         int index = digits.charAt(start)-'0';
     *         for(int i = 0; i < map[index].length(); i++){
     *             backtrack(res, map, digits, start+1, temp+map[index].charAt(i));
     *         }
     *     }
     */

    /**
     * 回溯的解法
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations1(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Integer, String> mappings = new HashMap<>();
        mappings.put(2, "abc");
        mappings.put(3, "def");
        mappings.put(4, "ghi");
        mappings.put(5, "jkl");
        mappings.put(6, "mno");
        mappings.put(7, "pqrs");
        mappings.put(8, "tuv");
        mappings.put(9, "wxyz");

        result.add("");
        for (char ch : digits.toCharArray()) {
            result = combine(result, mappings.get(ch - '0'));
        }
        return result;
    }

    private static List<String> combine(List<String> result, String s) {
        List<String> store = new ArrayList<>();
        for (String str : result) {
            for (char ch : s.toCharArray()) {
                store.add(str + ch);
            }
        }
        return store;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }
}
