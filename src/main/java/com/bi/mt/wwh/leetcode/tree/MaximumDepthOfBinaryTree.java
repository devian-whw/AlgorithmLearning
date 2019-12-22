package com.bi.mt.wwh.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangwenhao06@meituan.com
 * @create 2019-05-24 下午4:50
 **/
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     * 采用非递归实现
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ++res;
            for (int i = q.size(); i > 0; --i) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return res;
    }


    public static void main(String[] args) {


    }
}
