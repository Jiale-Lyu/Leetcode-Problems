package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/16/2023.
 */
public class P129_SumRoottoLeafNumbers {



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
    * DFS: top down dfs, dfs()一般不返回值
    *
    * */
    class Solution {
        int sum = 0;
        public int sumNumbers(TreeNode root) {
            if(root == null){
                return 0;
            }
            dfs(root, 0);
            return sum;
        }
        private void dfs(TreeNode node, int num){
            num = num * 10 + node.val;
            if(node.left == null && node.right == null){
                sum += num;
                return;
            }
            if(node.left != null){
                dfs(node.left, num);
            }
            if(node.right != null){
                dfs(node.right, num);
            }
        }
    }
}
