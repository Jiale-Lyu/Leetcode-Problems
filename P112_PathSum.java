package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 12/19/2022.
 */
public class P112_PathSum {

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
   * 深度优先，递归
   * time：O(n)
   * space：O(H)
   * */
    class Solution1 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            if(root.right == null && root.left == null && root.val == targetSum){
                return true;
            }
            return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
        }
    }

    /*
    * 广度优先，用两个队列分别存节点和从root到此节点的和
    * time: O(n),其中 n是树的节点数
    * space: O(n),其中 n是树的节点数
    * */
    class Solution2 {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null){
                return false;
            }
            Queue<TreeNode> queNode = new LinkedList<TreeNode>();
            Queue<Integer> queVal = new LinkedList<Integer>();
            queNode.offer(root);
            queVal.offer(root.val);

            while(!queNode.isEmpty()){
                TreeNode now = queNode.poll();
                int temp = queVal.poll();

                //如果此节点是叶子节点
                if(now.left == null && now.right == null){
                    if(temp == targetSum){
                        return true;
                    }
                    //是叶子节点，并且从root到此节点不等于targetSum，结束此次循环，继续处理队列里的下个节点
                    continue;
                }

                //把当前节点的左右孩子排进队列
                if(now.left != null){
                    queNode.offer(now.left);
                    queVal.offer(now.left.val + temp);
                }
                if(now.right != null){
                    queNode.offer(now.right);
                    queVal.offer(now.right.val + temp);
                }
            }
            return false;
        }
    }




}
