package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/16/2023.
 */
public class P124_BinaryTreeMaximumPathSum {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
    * DFS
    * time: O(n)
    *
    * */
    class Solution {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = dfs(node.left);
            int right = dfs(node.right);
            left = left < 0 ? 0 : left;
            right = right < 0 ? 0 : right;
            max = Math.max(max, left + right + node.val);
            return Math.max(left, right) + node.val;
        }

    }
}
