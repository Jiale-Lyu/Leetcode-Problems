package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/10/2023.
 */
public class P147_InsertionSortList {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    * 插入排序
    * time: O(n^2)
    * space: O(1)
    * */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if(head == null){
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            //lastSorted之前的都已排好序；cur从第二个节点开始向后遍历到最后一个节点
            ListNode lastSorted = head, cur = head.next;
            while(cur != null){
                //说明目前的顺序是对的，不用改（箭头应该指向大的）
                if(lastSorted.val <= cur.val){
                    lastSorted = lastSorted.next;
                }else{
                    ListNode pre = dummy;
                    //找到cur应该插入的前一个位置
                    while(pre.next.val <= cur.val){
                        pre = pre.next;
                    }
                    lastSorted.next = cur.next;
                    cur.next = pre.next;
                    pre.next = cur;
                }
                //注意是lastSorted.next
                cur = lastSorted.next;
            }
            return dummy.next;
        }
    }
}
