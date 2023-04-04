package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/18/2023.
 */
public class P637_AverageofLevelsinBinaryTree {



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
    * bfs
    * time: O(n)
    * space: O(n) 其中 n 是二叉树中的节点个数。空间复杂度取决于队列开销，队列中的节点个数不会超过 n
    * */
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if(root == null) return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                double sum = 0;
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
                result.add(sum / size);
            }
            return result;
        }
    }
}
