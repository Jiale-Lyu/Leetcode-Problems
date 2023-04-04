package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lv Jiale on 2/24/2023.
 */
public class P143_ReorderList {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /*
    * 存入List中用双指针
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public void reorderList(ListNode head) {
            if(head == null){
                return;
            }
            List<ListNode> list = new ArrayList<>();
            while(head != null){ //存入List中用双指针
                list.add(head);
                head = head.next;
            }
            int l = 0;
            int r = list.size() - 1;
            while(l < r){
                list.get(l).next = list.get(r);
                l++;
                if(l == r){ //l加完要判断是否相等，相等说明到最后一个节点了，跳出加null
                    break;
                }
                list.get(r).next = list.get(l);
                r--; //r减完不用判断相等，如果相等就不会继续循环
            }
            list.get(l).next = null;
        }
    }
}
