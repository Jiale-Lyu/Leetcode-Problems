package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/17/2023.
 */
public class P2_AddTwoNumbers {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    *
    * time：O(n)
    * space: O(1)
    * */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while(l1 != null || l2 != null){
                int x = l1 == null? 0 : l1.val;
                int y = l2 == null? 0 : l2.val;
                int sum = x + y + carry;
                carry = sum / 10; //得到十位数
                sum = sum % 10; //得到个位数

                cur.next = new ListNode(sum);
                cur = cur.next;

                if(l1 != null){ //注意不是l1.next
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }
            }
            if(carry != 0){
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }
    }
}
