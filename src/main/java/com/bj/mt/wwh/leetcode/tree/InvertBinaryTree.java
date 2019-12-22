package com.bj.mt.wwh.leetcode.tree;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-26 下午6:58
 **/
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tn = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tn);
        return root;
    }

}
