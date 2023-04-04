package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/18/2023.
 */
public class P513_FindBottomLeftTreeValue {


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
    * bfs, 每层从右到左遍历，最后一个节点的值就是最底层最左边节点的值
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int res = 0;
            while(!queue.isEmpty()){  //内层循环是为了一层一层地遍历，如果不需要逐层遍历，可以不要内循环
                TreeNode node = queue.poll();
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
                res = node.val;
            }
            return res;
        }
    }
}
