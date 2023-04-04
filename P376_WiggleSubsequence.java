package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/18/2023.
 */
public class P376_WiggleSubsequence {

    /*
    * 用up，down两个变量一次循环记录下数字大小改变的次数
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if(nums == null || n == 0){
                return 0;
            }
            int up = 1, down = 1; //用法巧妙
            for(int i = 1; i < n; i++){
                if(nums[i] > nums[i - 1]){
                    up = down + 1;
                }else if(nums[i - 1] > nums[i]){
                    down = up + 1;
                }
            }
            return Math.max(up, down);
        }
    }
}
