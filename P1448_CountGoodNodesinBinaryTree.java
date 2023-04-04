package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/2/2023.
 */
public class P1448_CountGoodNodesinBinaryTree {


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int res = 0;
        public int goodNodes(TreeNode root) {
            dfs(root.val, root);
            return res;
        }
        public void dfs(int max, TreeNode node){
            if(node == null){
                return;
            }
            if(node.val >= max){
                res += 1;
                max = node.val;
            }
            dfs(max, node.left);
            dfs(max, node.right);
        }
    }
}
