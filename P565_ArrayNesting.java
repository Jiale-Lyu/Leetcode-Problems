package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/30/2023.
 */
public class P565_ArrayNesting {


    /*
    * 观察总结规律
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int arrayNesting(int[] nums) {
            int res = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == -1){
                    continue;
                }
                int next = nums[i], size = 1;
                while(next != i){  //前提：一定能成环，环一定终止于入口元素
                    int tmp = nums[next];
                    nums[next] = -1;  //把遍历过的环中的数置为-1，以环中任意一个数开头的长度一样
                    size++;
                    next = tmp;
                }
                res = Math.max(res, size);
            }
            return res;
        }
    }
}
