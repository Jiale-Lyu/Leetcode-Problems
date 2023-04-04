package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lv Jiale on 1/19/2023.
 */
public class P94_BinaryTreeInorderTraversal {


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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }
        public void dfs(TreeNode root, List<Integer> res){
            if(root == null) return;
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
        }
    }

    /*
    * 迭代
    * */
    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while(!stack.isEmpty() || root != null){
                while(root != null){ //一直向左走，压栈
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop(); //走到头了弹出一个
                res.add(root.val); //处理
                root = root.right; //找右孩子
            }
            return res;
        }
    }
}
