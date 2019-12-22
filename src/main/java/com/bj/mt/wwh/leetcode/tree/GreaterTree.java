package com.bj.mt.wwh.leetcode.tree;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-04-07 下午4:31
 * 538. Convert BST to Greater Tree
 **/
public class GreaterTree {
    private int add = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        add = add + root.val;
        root.val = add;
        convertBST(root.left);
        return root;

    }
}
