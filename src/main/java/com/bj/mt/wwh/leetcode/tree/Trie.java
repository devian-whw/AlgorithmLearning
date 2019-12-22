package com.bj.mt.wwh.leetcode.tree;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-27 下午4:55
 * 字典树的性质:
 * 根节点不包含字符，根节点外每一个节点都只包含一个字符
 * 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。
 * 每个节点的所有子节点包含的字符串不相同
 * 核心思想是空间换时间，利用字符串的公共前缀来减少无谓的字符串比较以达到提高查询效率的目的。
 * 2fb000a9eb017fe750a425f4a03898ce47469918
 * https://juejin.im/post/5c2c096251882579717db3d2
 * https://github.com/Learn-Algorithm/Learn-Algorithm/blob/master/1-%E6%A0%91/3-%E5%AD%97%E5%85%B8%E6%A0%91Trie/caven/Trie.java
 **/
public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        TrieNode tNode = root;
        char[] letters = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = letters[i] - 'a';
            if (tNode.son[pos] == null) {
                // 判断当前结点中是否存在字符
                tNode.son[pos] = new TrieNode();
                tNode.son[pos].val = letters[i];
            }
            // 在一条路径下存储一个单词
            tNode = tNode.son[pos];
        }
        tNode.last = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode tNode = root;
        char[] letters = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = letters[i] - 'a';
            if (tNode.son[pos] != null && tNode.son[pos].val == letters[i]) {
                tNode = tNode.son[pos];
            } else {
                return false;
            }
        }

        return tNode.last;
    }

    public boolean search1(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode tNode = root;
        for (char c : word.toCharArray()) {
            int pos = c - 'a';
            if (tNode.son[pos] != null) {
                tNode = tNode.son[pos];
            } else {
                return false;
            }
        }

        return tNode.last;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode tNode = root;
        for (char c : prefix.toCharArray()) {
            int pos = c - 'a';
            // 不必是结尾，符合前缀即可
            if (tNode.son[pos] == null || tNode.son[pos].val != c) {
                return false;
            }
            tNode = tNode.son[pos];
        }
        return true;
    }

    static class TrieNode {

        /**
         * 是否是最后一个结点
         */
        private boolean last;

        private char val;
        private TrieNode[] son;

        public TrieNode() {
            this.last = false;
            this.son = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("search:" + trie.search("apple"));

    }

}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */