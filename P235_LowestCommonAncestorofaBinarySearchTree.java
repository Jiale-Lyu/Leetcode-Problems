package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lv Jiale on 1/20/2023.
 */
public class P235_LowestCommonAncestorofaBinarySearchTree {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /*
    * 两次遍历
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> p_path = getPath(root, p);
            List<TreeNode> q_path = getPath(root, q);
            TreeNode ancestor = null;
            //p,q的最近公共祖先是从root开始的两条路径的最后一个分岔点
            for(int i = 0; i < p_path.size() && i < q_path.size(); i++){
                if(p_path.get(i) == q_path.get(i)){
                    ancestor = p_path.get(i);
                }else{
                    break;
                }
            }
            return ancestor;
        }


        //返回从root到target的路径，存在ArrayList中
        public List<TreeNode> getPath(TreeNode root, TreeNode target){
            List<TreeNode> path = new ArrayList<>();
            TreeNode node = root;
            while(node != target){
                path.add(node);
                //如果node大于target，说明在target的右边，所以要向左找
                if(node.val > target.val){
                    node = node.left;
                }else{
                    node = node.right;
                }
            }
            path.add(node);
            return path;
        }
    }


    /*
    * 单次遍历
    * time：O(n)
    * space: O(1)
    * */
    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ancester = root;
            //利用BST的特性，p,q都小于ancester时，往左找；都大于ancester时，往右找
            while (true) {
                if (ancester.val > p.val && ancester.val > q.val) {
                    ancester = ancester.left;
                } else if (ancester.val < p.val && ancester.val < q.val) {
                    ancester = ancester.right;
                } else {
                    break;
                }
            }
            return ancester;
        }
    }
}
