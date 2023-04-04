package com.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Lv Jiale on 11/12/2022.
 * 双指针反转链表
 * solution: https://leetcode.cn/problems/reverse-linked-list/solutions/36710/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 */
public class P206_ReverseLinkedList {

//   Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //My solution: use stack to reverse linkedlist.
    // 栈
    //time complexity: O(N)
    //space complexity: O(1)
//    public ListNode reverseList(ListNode head) {
//        if(head == null) return null;
//        Deque<ListNode> stack = new LinkedList<ListNode>();
//        while(head != null){
//            stack.push(head);
//            head = head.next;
//        }
//        head = stack.pop();
//        ListNode newHead = head;
//        while(!stack.isEmpty()){
//            head.next = stack.pop();
//            head = head.next;
//        }
//        head.next = null;
//        return newHead;
//    }



    /**
     *     time: O(N)
     *     space: O(1)
     * 双指针迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    //recursion??
}
