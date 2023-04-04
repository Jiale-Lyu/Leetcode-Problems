package com.leetcode.solution;

/**
 * Created by Lv Jiale on 12/16/2022.
 */
public class P110_BalancedBinaryTree {

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

    /*
    * 自顶向下递归
    * time: O(n^2) ???
    * space: O(n)其中 n 是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n
    * */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }else{
                return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
            }
        }

        public int height(TreeNode root){
            if(root == null){
                return 0;
            }else{
                return Math.max(height(root.left), height(root.right)) + 1;
            }
        }
    }

    /*
    * 自底向上递归
    * */
}
