package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Lv Jiale on 12/13/2022.
 */
public class P234_PalindromeLinkedList {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /*
    * 我的方法， 用栈
    * time: O(n)
    * space:O(n)
    * */
    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            ListNode p = head;
            while(p != null){
                stack.push(p.val);
                p = p.next;
            }
            while(head!= null){
                int cur = stack.pop();
                if(cur != head.val){
                    return false;
                }
                head = head.next;
            }
            return true;
        }
    }


    /*
    * 复制到arraylist，用双指针前后同时对比
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            List<Integer> vals = new ArrayList<Integer>();

            ListNode currentNode = head;
            while(currentNode!=null){
                vals.add(currentNode.val);
                currentNode = currentNode.next;
            }

            int front = 0;
            int back = vals.size()-1;
            while(front < back){
                if(vals.get(front) != vals.get(back)){
                    return false;
                }
                front++;
                back--;
            }
            return true;
        }
    }

    /*
    * 最优解
    * 用快慢指针遍历一次，同时反转链表前半部分，从中间开始对比
    * time: O(n)
    * space: O(1)
    * */
    class Solution3 {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null){
                return true;
            }
            ListNode fast = head, slow = head;
            ListNode pre = head, prepre = null;
            while(fast != null && fast.next != null){
                pre = slow;
                slow = slow.next;
                fast = fast.next.next; //fast走到链尾时，slow走到中间
                //反转
                pre.next = prepre;
                prepre = pre;
            }
            //当节点个数为奇数个时，slow往后走一步，跳过单个的中间节点
            if(fast != null){
                slow = slow.next;
            }
            //pre从中间往前，slow从中间往后
            while(pre!= null && slow != null){
                if(pre.val != slow.val){
                    return false;
                }
                pre = pre.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
