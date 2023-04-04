package com.leetcode.solution;

/**
 * Created by Lv Jiale on 11/12/2022.
 */

import java.util.HashSet;
import java.util.Set;

//solution: https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/

public class P160_IntersectionofTwoLinkedLists {

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Time Complexity: O(m + n)
    //Space Complexity: O(m)
    //m: the length of headA, n: the length of headB

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> visited = new HashSet<ListNode>();
//        ListNode temp = headA;
//        while(temp != null){
//            visited.add(temp);
//            temp = temp.next;
//        }
//        temp = headB;
//        while(temp != null){
//            if(visited.contains(temp)){
//                return temp;
//            }
//            temp = temp.next;
//        }
//        return null;
//
//    }


    //time complexity: O(N) m+n
    //space complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
