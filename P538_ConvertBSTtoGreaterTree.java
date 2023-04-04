package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/19/2023.
 */
public class P538_ConvertBSTtoGreaterTree {


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
    * 递归，中序遍历左中右，反过来变成右中左，sum累加
    * */
    class Solution {
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                sum += root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }

}
