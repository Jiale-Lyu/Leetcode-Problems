package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 12/16/2022.
 */
public class P104_MaximumDepthofBinaryTree {


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
    *
    *dfs
    * time: O(n), 其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
    * space: O(height), 其中 height表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度
    * */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }

    /*
    * bfs
    * 根节点的高度就是二叉树的最大深度
    * */

    class Solution2 {
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0;
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }
}
