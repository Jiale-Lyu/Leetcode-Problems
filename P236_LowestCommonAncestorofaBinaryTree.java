package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/28/2023.
 */
public class P236_LowestCommonAncestorofaBinaryTree {



//    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /*
    * 递归
    * time: O(n), 其中 N 为二叉树节点数；最差情况下，需要递归遍历树的所有节点。
    * space: O(n), 最差情况下，递归深度达到 N
    * */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q){ //递归终止条件：叶子节点或者root就是p，q其中一个
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // if(left == null && right == null) return null; //这句可以合并到下面
            if(left == null) return right; //左边是空说明公共节点在右边
            if(right == null) return left;
            return root;
        }
    }

//solution: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/240096/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
}
