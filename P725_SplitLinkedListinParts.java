package com.leetcode.solution;

/**
 * Created by Lv Jiale on 12/13/2022.
 */
public class P725_SplitLinkedListinParts {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /*
    * time: O(n)
    * space: O(k)
    * */
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            int n = 0;
            ListNode p = head;
            while(p != null){ //计算链表长度
                n++;
                p = p.next;
            }
            int[] times = new int[k];
            int a = n / k;
            int b = n % k;
            for(int i = 0; i < k; i++){ //存每个区间的节点数
                times[i] = a;
                if(i < b){
                    times[i]++;
                }
            }
            ListNode[] res = new ListNode[k];
            for(int i = 0; i < k; i++){
                int time = times[i];
                res[i] = head;
                ListNode q = head;
                while(time > 1){
                    q = q.next;
                    head = head.next;
                    time--;
                }
                if(head == null){
                    continue;
                }else{
                    head = head.next;
                }
                q.next = null;
            }
            return res;
        }
    }
}
