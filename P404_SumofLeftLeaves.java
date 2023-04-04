package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/18/2023.
 */
public class P404_SumofLeftLeaves {

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
   * dfs
   * 注意只算左叶子节点
   * time: O(n)
   * space: O(n)
   * */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null) return 0;
            int l = 0;
            if(root.left != null && root.left.left == null && root.left.right == null){
                l += root.left.val;
            }
            return l + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

}
