package com.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Lv Jiale on 12/12/2022.
 */
public class P19_RemoveNthNodeFromEndofList {

    // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


     /*
     * time: O(n)
     * space: O(1)
     * 双重遍历, 先计算链表的长度
     * 建一个dummy node，next为头节点防止头节点被删，返回dummy.next
     * */
    class Solution1 {
         public ListNode removeNthFromEnd(ListNode head, int n) {
             ListNode dummy = new ListNode(0, head);
             int length = getLength(head);
             ListNode cur = dummy;
             for (int i = 1; i < length - n + 1; i++) {
                 cur = cur.next;
             }
             cur.next = cur.next.next;
             ListNode ans = dummy.next;
             return ans;
         }

         int getLength(ListNode head) {
             int length = 0;
             while (head != null) {
                 length++;
                 head = head.next;
             }
             return length;
         }
     }



    /*
    * time: O(n)
    * space: O(n)
    * 堆栈
    * peek() 检索但不删除由此deque表示的队列的头部（换句话说，此deque的第一个元素），如果此deque为空，则返回 null 。
    * */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<ListNode>();
            ListNode cur = dummy;
            while(cur != null){
                stack.push(cur);
                cur = cur.next;
            }
            for(int i = 0; i < n; i++){
                stack.pop();
            }
            ListNode prev = stack.peek();
            prev.next = prev.next.next;
            return dummy.next;
        }

    }


    /*
    * 双指针，一前一后，中间相隔固定数量的值
    * time: O(n)
    * space: O(1)
    * */
    class Solution3 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummy;
            for(int i = 0; i < n; i++){
                first = first.next;
            }
            while(first!=null){
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;

        }

    }

}
