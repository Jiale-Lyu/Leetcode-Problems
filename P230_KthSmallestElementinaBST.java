package com.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Lv Jiale on 1/19/2023.
 */
public class P230_KthSmallestElementinaBST {

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
    * 中序遍历
    * time：O(H + k), 最好O(logn + k), 最坏O(n+k)
    * space： O(H), 最好O(logn), 最坏O(n)
    * */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new LinkedList<>();
            while(!stack.isEmpty() || root != null){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                k--; //弹出一个k--，当k==0时，弹出的就是第k小的元素
                if(k == 0){
                    break;
                }
                root = root.right;
            }
            return root.val;
        }
    }

    /*
    * time: O(n)
    * space: O(n)
    * */
    class Solution2 {
        int val;
        int cnt = 0;
        public int kthSmallest(TreeNode root, int k) {
            inOrder(root, k);
            return val;
        }
        public void inOrder(TreeNode root, int k){ //中序遍历模板
            if(root == null) return;
            inOrder(root.left, k);
            cnt++;
            if(cnt == k){
                val = root.val;
                return;
            }
            inOrder(root.right, k);
        }
    }
}
