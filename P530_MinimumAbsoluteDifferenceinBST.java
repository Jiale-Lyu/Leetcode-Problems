package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/26/2023.
 */
public class P530_MinimumAbsoluteDifferenceinBST {


//    Definition for a binary tree node.
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
    * inOrder
    * time: O(n), n 为节点个数，每个节点都会被遍历一次
    * space: O(n)， 取决于栈深度，bst为一条链的情况下深度为n
    * */
    class Solution {
        int min = Integer.MAX_VALUE;
        TreeNode pre = null;
        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return min;
        }
        public void inOrder(TreeNode node){
            if(node == null) return;
            inOrder(node.left);
            if(pre != null){
                min = node.val - pre.val < min ? node.val - pre.val : min;
            }
            pre = node;
            inOrder(node.right);
        }
    }
}
