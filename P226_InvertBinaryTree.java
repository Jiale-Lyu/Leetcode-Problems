package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 12/18/2022.
 */
public class P226_InvertBinaryTree {


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
    * 深度优先递归，注意终止条件
    * time: O(n) n个节点
    * space: O(h) h为树高
    * */
    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

    /*
    * 广度优先，用队列迭代
    * time: O(n)
    * space: O(n)
    * */
    class Solution2 {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                //交换左右子节点
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = temp;
                //把下一层子节点都进队列
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }
}
