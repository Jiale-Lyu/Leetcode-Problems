package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 3/26/2023.
 */
public class P501_FindModeinBinarySearchTree {



//    Definition for a binary tree node.
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
    * Brute Force, hashmap
    * time: O(n)
    * time: O(n)
    * */
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public int[] findMode(TreeNode root) {
            inOrder(root);
            int maxValue = 1;
            List<Integer> res = new ArrayList<>();
            for(int k : map.keySet()){
                if(map.get(k) == maxValue){
                    res.add(k);
                }else if(map.get(k) > maxValue){
                    maxValue = map.get(k);
                    res.clear();
                    res.add(k);
                }
            }
            int[] mode = new int[res.size()];
            for(int i = 0; i < res.size(); i++){
                mode[i] = res.get(i);
            }
            return mode;
        }
        public void inOrder(TreeNode node){ //中序遍历
            if(node == null) return;
            inOrder(node.left);
            if(map.containsKey(node.val)){
                map.put(node.val, map.get(node.val)+1);
            }else{
                map.put(node.val, 1);
            }
            inOrder(node.right);
        }
    }

    /*
    * inorder traverse
    * time: O(n)
    * space: O(n)
    * */
 class Solution2 {
     List<Integer> res = new ArrayList<>();
     TreeNode pre = null;
     int cnt = 1;
     int maxcnt = 1;

     public int[] findMode(TreeNode root) {
         inOrder(root);
         int[] mode = new int[res.size()];
         for(int i = 0; i < res.size(); i++){
             mode[i] = res.get(i);
         }  //因为list是Integer类型，返回是int类型，不能用res.toArray(new int[res.size()])
         return mode;
     }
     public void inOrder(TreeNode node){ //中序遍历
         if(node == null) return;
         inOrder(node.left);
         update(node);
         inOrder(node.right);
     }
     public void update(TreeNode node){ //检查当前节点值是否与前一个节点值相等
         if(pre != null){
             if(pre.val == node.val){
                 cnt++;
             }else{
                 cnt = 1;
             }
         }

         if(cnt == maxcnt){
             res.add(node.val);
         }else if(cnt > maxcnt){
             maxcnt = cnt;
             res.clear();
             res.add(node.val);
         }
         pre = node;
     }
 }
}
