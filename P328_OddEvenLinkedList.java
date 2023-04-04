package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/24/2023.
 */
public class P328_OddEvenLinkedList {



    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    * 双指针
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null){
                return head;
            }
            ListNode p = head; //odd pointer
            ListNode q = head.next; //even pointer
            ListNode even = head.next;
            while(p.next != null && q.next != null){
                p.next = q.next;
                p = p.next; //记得更新完next，指针要向后移动！！！！！！！！！！！！！！1
                q.next = p.next;
                q = q.next;
            }
            p.next = even;
            return head;
        }
    }
}
