package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/16/2023.
 */
public class P101_SymmetricTree {

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
    * DFS 更好
    * time: O(n) 因为要遍历n个节点
    * space: O(n) 空间复杂度是递归的深度，也就是跟树高度有关，最坏情况下树变成一个链表结构，高度是n
    * */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return dfs(root.left, root.right);
        }
        private boolean dfs(TreeNode left,TreeNode right){
            if(left == null && right == null){
                return true;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }

    /*
    * BFS:
    * time: O(n)
    * space: O(n)
    * */
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if(root == null || (root.left == null && root.right == null)){
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while(queue.size() > 0){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if(left == null && right == null){
                    continue;
                }
                if(left == null || right == null){
                    return false;
                }
                if(left.val != right.val){
                    return false;
                }
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;
        }
    }
}
