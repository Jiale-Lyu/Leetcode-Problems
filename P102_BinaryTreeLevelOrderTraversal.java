package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/16/2023.
 */
public class P102_BinaryTreeLevelOrderTraversal {

    /**
     * Definition for a binary tree node.
     * */
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /*
    * BFS
    * time: O(n)
    * space:
    * */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){ //循环遍历层
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                for(int i = 0; i < size; i++){ //每一层的所有节点遍历
                    TreeNode cur = queue.poll();
                    level.add(cur.val);
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }
}
