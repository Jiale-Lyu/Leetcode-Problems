package com.leetcode.solution;

/**
 * Created by Lv Jiale on 12/16/2022.
 */
public class P543_DiameterofBinaryTree {

    //Definition for a binary tree node.
    public class TreeNode {int val;
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
    * 深度优先搜索
    * time: O(n)
    * space: O(root.depth)
    * */
    class Solution {
        //定义全局变量
        int maxd = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return maxd;
        }
        public int depth(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = depth(root.left);
            int right = depth(root.right);
            maxd = Math.max(maxd, left+right); //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
            return Math.max(left, right) + 1; //返回节点深度
        }
    }
}
