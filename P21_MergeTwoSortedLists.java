package com.leetcode.solution;

/**
 * Created by Lv Jiale on 11/13/2022.
 */
public class P21_MergeTwoSortedLists {

    /*
    Definition for singly-linked list.
    https://leetcode.cn/problems/merge-two-sorted-lists/solutions/103891/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
    */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*
    * time: O(m+n)
    * space: O(m+n)
    * 递归，调用自己
    * 递归算法的空间复杂度 = 每次递归的空间复杂度 * 递归深度
    * 每次递归的空间复杂度是O(1)， 调用栈深度为n，最后 这个递归算法的空间复杂度就是 n * 1 = O（n）
    * */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null){
                return list2;
            }else if(list2 == null){
                return list1;
            }else if(list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }else{
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

    /*
    * 迭代
    * time: O(m+n)
    * space: O(1)
    *
    * */
    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode pre = new ListNode(-1); //定义一个pre，就不用纠结用哪个做头了
            ListNode cur = pre;
            while(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    cur.next = list1;
                    list1 = list1.next;
                }else{
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next; //记得cur要向后走
            }
            cur.next = list1 == null ? list2 : list1;
            return pre.next;
        }
    }
}
