package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/17/2023.
 */
public class P98_ValidateBinarySearchTree {

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
    * dfs中序遍历
    *
    * */
    class Solution {
        long pre = Long.MIN_VALUE;
        public boolean isValidBST(TreeNode root) {
            if(root == null){ //终止条件
                return true;
            }
            if(!isValidBST(root.left)){ //判断左子树
                return false;
            }
            if(root.val <= pre){ //如果当前数小于等于前一个数，返回false
                return false;
            }
            pre = root.val; //左子树和中间都是true了，把中间放到pre里，接着判断右子树
            return isValidBST(root.right);
        }
    }

    /*
    * time: O(n) n为节点的个数
    * space: O(n) 递归的深度即二叉树的高度，最坏情况为n
    * */
    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }
        private boolean isValidBST(TreeNode root, Integer min, Integer max){
            if(root == null) return true;
            if((min != null && root.val <= min) || (max != null && root.val >= max)){
                return false;
            }
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
    }
}
