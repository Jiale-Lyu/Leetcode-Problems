package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/19/2023.
 */
public class P669_TrimaBinarySearchTree {


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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if(root == null) return null;
            if(root.val < low){
                return trimBST(root.right, low, high); //保留左子树，处理右子树
            }else if(root.val > high){
                return trimBST(root.left, low, high); //保留右子树，处理左子树
            }else{ //保留root，处理左右子树
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            }
        }
    }
}
