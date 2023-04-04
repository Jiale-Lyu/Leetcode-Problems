package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 1/23/2023.
 */
public class P653_TwoSumIVInputisaBST {


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
    * 深度优先dfs+ hashset
    * time: O(n), 树的每个节点遍历一遍
    * space: O(n), hashset的开销，最坏情况要将每个点都加入哈希表一次
    * */
    class Solution {
        //用set而不是map，map会出现key与value相同，误判为真的情况
        Set<Integer> set = new HashSet<>();
        public boolean findTarget(TreeNode root, int k) {
            if(root == null){
                return false;
            }
            if(set.contains(k - root.val)){
                return true;
            }
            set.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }


    /*
    * bfs + hashset
    * time: O(n), 树的每个节点遍历一遍
    * space: O(n), hashset的开销，最坏情况要将每个点都加入哈希表一次
    * */
    class Solution2 {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return false;
        }
    }

    /*
    * dfs中序遍历 + 左右双指针
    * time: O(n)
    * space: O(m)
    * */
    class Solution3 {
        List<Integer> list = new ArrayList<>();
        public boolean findTarget(TreeNode root, int k) {
            inorderTraversal(root);
            int left = 0, right = list.size() - 1;
            while(left < right){
                if(list.get(left) + list.get(right) == k){
                    return true;
                }else if(list.get(left) + list.get(right) < k){
                    left++;
                }else{
                    right--;
                }
            }
            return false;
        }
        public void inorderTraversal(TreeNode node){
            if(node == null) return;
            inorderTraversal(node.left);
            list.add(node.val);
            inorderTraversal(node.right);
        }
    }
}
