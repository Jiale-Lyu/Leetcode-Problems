package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 1/5/2023.
 */
public class P496_NextGreaterElement_I {

    /*
    * 暴力解法
    * time: O(nm)
    * space: O(1)
    * */
    class Solution1 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int[] ans = new int[m];
            for(int i = 0; i < m; i++){
                int j = 0;
                while(j < n && nums1[i] != nums2[j]){
                    j++;
                }
                int k = j++;
                while(k < n && nums2[k] <= nums1[i]){
                    k++;
                }
                ans[i] = k < n ? nums2[k] : -1;
            }
            return ans;
        }
    }

    /*
    *
    * 单调栈
    * time: O(m+n)
    * space: O(n)
    *
    * 比栈顶元素大：弹出栈顶元素 + 入栈
    * 比栈顶元素小 || 栈为空：入栈
    * */
    class Solution2 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //用hashmap存对应元素
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for(int i = nums2.length - 1; i >= 0; i--){ //从后往前遍历
                int num = nums2[i];
                while(!stack.isEmpty() && num >= stack.peek()){ //栈里有数，并且新来的更大，弹出栈里较小的元素
                    stack.pop();
                }
                map.put(num, stack.isEmpty() ? -1 : stack.peek());
                stack.push(num);
            }

            int[] ans = new int[nums1.length];
            for(int i = 0; i < nums1.length; i++){
                ans[i] = map.get(nums1[i]);
            }
            return ans;

        }
    }

}
