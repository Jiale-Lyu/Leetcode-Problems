package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/20/2023.
 */
public class P108_ConvertSortedArraytoBinarySearchTree {


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
    * time: O(n)
    * space: O(logn) 递归栈的深度
    * */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
        public TreeNode helper(int[] nums, int left, int right){
            if(left > right){
                return null;
            }
            //总是取中间或中间靠左的数当mid
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1); //给root的左子树赋值
            root.right = helper(nums, mid + 1, right); //给root的右子树赋值
            return root;
        }
    }
}
