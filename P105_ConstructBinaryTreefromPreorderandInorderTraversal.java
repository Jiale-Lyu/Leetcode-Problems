package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 3/3/2023.
 */
public class P105_ConstructBinaryTreefromPreorderandInorderTraversal {


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
    * 递归建树
    * time: O(n) n是树中节点个数
    * space: O(n) 除了返回答案的O（n）外，hashmap： O（n）， 递归时栈的空间O(h)树的高度，这里h < n
    * */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int preLen = preorder.length;
            int inLen = inorder.length;
            if(preLen != inLen){
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>(); //把inorder的数值和index存入hashmap中便于获取下标
            for(int i = 0; i < inLen; i++){
                map.put(inorder[i], i);
            }
            //前序遍历，第一个下边，最后一个下标，中序遍历，第一个下标，最后一个下标
            return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
        }
        //overloading 函数重载（同名不同参）
        public TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight){
            if(preLeft > preRight || inLeft > inRight){
                return null;
            }
            int rootVal = preorder[preLeft];
            TreeNode root = new TreeNode(rootVal);
            int pIndex = map.get(rootVal);
            //画图方便确定值
            root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
            root .right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
            return root;
        }
    }
}
