package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lv Jiale on 1/18/2023.
 */
public class P144_BinaryTreePreorderTraversal {



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
    * time: O(n), n为二叉树节点数
    * space: O(n)， 栈开销，平均情况是O(logn),最坏情况为链状O(n)
    * */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }
        private void dfs(TreeNode node, List<Integer> res){
            if(node == null) return;
            res.add(node.val);
            dfs(node.left, res);
            dfs(node.right, res);
        }
    }

    /*
    * 迭代， 用stack
    * 前序遍历，中左右，先中，再压右，再压左，pop顺序就是左右
    * time: O(n), n为二叉树节点数
    * space: O(n)， 栈开销，平均情况是O(logn),最坏情况为链状O(n)
    * */
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                res.add(node.val);
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
            return res;
        }
    }
}

