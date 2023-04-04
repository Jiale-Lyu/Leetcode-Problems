package com.leetcode.solution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Lv Jiale on 3/2/2023.
 */
public class P23_MergekSortedLists {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /*
    * 优先队列维护一个小根堆，每次poll出最小的，指向next
    * time: O(knlogk)
    * space: O(k) 优先队列中的元素不超过k个
    * */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val)); //优先队列默认维护一个小根堆
            for(ListNode node: lists){ //把k个头节点放入pq中
                if(node != null){
                    pq.offer(node);
                }
            }
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            while(!pq.isEmpty()){
                ListNode minNode = pq.poll();
                tail.next = minNode;
                tail = minNode;
                if(minNode.next != null){
                    pq.offer(minNode.next);
                }
            }
            return dummy.next;
        }
    }
}
