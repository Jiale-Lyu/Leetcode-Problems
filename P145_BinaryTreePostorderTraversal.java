package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 1/19/2023.
 */
public class P145_BinaryTreePostorderTraversal {



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
    * */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }
        public void dfs(TreeNode root, List<Integer> res){
            if(root == null) return;
            dfs(root.left, res);
            dfs(root.right, res);
            res.add(root.val);
        }
    }

    /*
    * 迭代，后序遍历左右中，前序为中左右，改为中右左，再反转一下，变成左右中。
    *
    * */
    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Deque<TreeNode> stack1 = new LinkedList<>();
            Deque<TreeNode> stack2 = new LinkedList<>();
            stack1.push(root);
            while(!stack1.isEmpty()){
                TreeNode node = stack1.pop();
                stack2.push(node);
                if(node.left != null){
                    stack1.push(node.left);
                }
                if(node.right != null){
                    stack1.push(node.right);
                }
            }
            while(!stack2.isEmpty()){
                res.add(stack2.pop().val);
            }
            return res;
        }
    }

    /*
    * 迭代，用collections.reverse()反转list
    * */
    class Solution3 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                res.add(node.val);
                if(node.left != null){
                    stack.push(node.left);
                }
                if(node.right != null){
                    stack.push(node.right);
                }
            }
            Collections.reverse(res);
            return res;
        }
    }
}
