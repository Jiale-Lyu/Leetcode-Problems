package com.leetcode.solution;

/**
 * Created by Lv Jiale on 12/12/2022.
 */
public class P83_RemoveDuplicatesfromSortedList {

    //Definition for singly-linked list.
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
    * time: O(n)
    * space: O(1)
    * 空间复杂度(Space Complexity)是对一个算法在运行过程中临时占用存储空间大小的量度
    * 如果算法执行所需要的临时空间不随着某个变量n的大小而变化,即此算法空间复杂度为一个常量 O(1)
    * 要判空！！！
    * */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode p = head;
            while (p.next != null) {
                if (p.val == p.next.val) { //后后面节点值相等的时候更新next的指向
                    p.next = p.next.next;
                } else {
                    p = p.next; //不相等的时候p往后走
                }
            }
            return head;
        }
    }
}
