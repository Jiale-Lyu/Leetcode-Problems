package com.leetcode.solution;

/**
 * Created by Lv Jiale on 12/19/2022.
 */
public class P617_MergeTwoBinaryTrees {

    // Definition for a binary tree node.
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
     *深度优先搜索，递归
     * time: O(min(m, n))
     * space: O(min(m, n))
     * */
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1 == null){
                return root2;
            }
            if(root2 == null){
                return root1;
            }
            TreeNode merged = new TreeNode(root1.val + root2.val);
            merged.left = mergeTrees(root1.left, root2.left);
            merged.right = mergeTrees(root1.right, root2.right);
            return merged;
        }
    }

    /*
    * 广度优先搜索
    *
    * */
}
