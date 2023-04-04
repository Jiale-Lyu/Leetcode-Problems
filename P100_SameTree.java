package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/19/2023.
 */
public class P100_SameTree {


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
    * 递归
    * time：O(min(m, n))
    * space: O(min(m, n))
    * */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null){ //先设定终止条件
                return true;
            }else if(p == null || q == null){
                return false;
            }else if(p.val != q.val){
                return false;
            }else{
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
