package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Lv Jiale on 12/13/2022.
 */
public class P445_AddTwoNumbersII {

//    Definition for singly-linked list.


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /*
    * 逆序用栈结构
    * time: O(max(m+n))
    * space: O(m+n) 栈的长度随链表的长度而变化
    * */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new ArrayDeque<Integer>();
            Deque<Integer> stack2 = new ArrayDeque<Integer>();

            while(l1!=null){
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while(l2!=null){
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode ans = null;

            //stack1有值 || stack2有值 || 有进位值
            while(!stack1.isEmpty() || !stack2.isEmpty() || carry!=0){
                int a = stack1.isEmpty()? 0 : stack1.pop();
                int b = stack2.isEmpty()? 0 : stack2.pop();
                int cur = a + b + carry;
                carry = cur / 10;
                cur = cur % 10;
                //倒序产生一个linkedlist
                ListNode curNode = new ListNode(cur);
                curNode.next = ans;
                ans = curNode;
            }
            return ans;

        }
    }
}
