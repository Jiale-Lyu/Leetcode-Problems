package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/16/2023.
 */
public class P199_BinaryTreeRightSideView {

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
    * BFS 先加右孩子，再加左孩子，每层循环开始的时候，队列中第一个就是这一层的最右边节点
    * time: O(n)
    * space:O()
    * */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                res.add(queue.peek().val);
                for(int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                }
            }
            return res;
        }
    }
}
