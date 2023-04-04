package com.leetcode.solution;

/**
 * Created by Lv Jiale on 12/12/2022.
 */
public class P24_SwapNodesinPairs {

    //Definition for singly-linked list.
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    * 递归
    * time: O(n)
    * space: O(n)
    * */
    class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if(head== null || head.next==null){
                return head;
            }
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
    }

    /*
    * 迭代法， temp是接下来两个要交换的节点前的一个helper， 判断temp后没有节点或只有一个节点终止循环
    * time: O(n)
    * space: O(1)??
    *
    * */
    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode temp = dummy;
            while(temp.next != null && temp.next.next != null){
                ListNode node1 = temp.next;
                ListNode node2 = temp.next.next;
                temp.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                temp = node1;
            }
            return dummy.next;
        }
    }
}
