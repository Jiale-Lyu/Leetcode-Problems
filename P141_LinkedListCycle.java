package com.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lv Jiale on 1/29/2023.
 */
public class P141_LinkedListCycle {


    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    * hashset 存node
    * time: O(n)
    * space: O(n)
    * */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while(head != null){
                if(!set.add(head)){
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }

    /*
    * 快慢指针
    * time: O(n)
    * space: O(1)
    * */
    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow != fast){
                if(fast == null || fast.next == null){
                    return false;
                }
                //慢的一次走一步，快的一次走两步
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
