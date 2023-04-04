package com.leetcode.solution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Lv Jiale on 1/5/2023.
 */

/*
*  单调栈
*  time: O(n)
*  space: O(n)
* 循环数组不用铺平，取模操作可以把前n-1个元素加到数组后面
* */
public class P503_NextGreaterElement_II {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            Deque<Integer> stack = new LinkedList<Integer>();
            int[] res = new int[n];  // new
            Arrays.fill(res, -1);  //Arrays
            for(int i = 0; i < 2 * n - 1; i++){
                while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]){
                    res[stack.pop()] = nums[i % n];  //stack里存的是下标
                }
                stack.push(i % n);
            }
            return res;
        }
    }
}
