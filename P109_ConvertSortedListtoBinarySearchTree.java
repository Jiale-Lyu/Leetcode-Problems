package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lv Jiale on 3/27/2023.
 */
public class P109_ConvertSortedListtoBinarySearchTree {


//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


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
    * 找中点当root，左右递归建树
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null){
                return null;
            }
            if(head.next == null){
                return new TreeNode(head.val);
            }
            List<Integer> list = new ArrayList<>(); //放入list好通过index得到值
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
            return buildTree(0, list.size() - 1, list);
        }
        //递归建树
        public TreeNode buildTree(int l, int r, List<Integer> list){
            if(l > r){
                return null;
            }
            int mid = l + (r - l + 1) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = buildTree(l, mid - 1, list);
            root.right = buildTree(mid + 1, r, list);
            return root;
        }
    }

    /*
    * 快慢指针
    * time: O(nlogn) 找中点logn + 遍历n个节点
    * space: O(logn) 递归栈的调用深度
    * */
    class Solution2 {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null){
                return null;
            }
            if(head.next == null){
                return new TreeNode(head.val);
            }
            ListNode fast = head, slow = head, pre = head;
            while(fast != null && fast.next != null){
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;
            ListNode right = slow.next;
            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(right);
            return root;
        }
    }
}
