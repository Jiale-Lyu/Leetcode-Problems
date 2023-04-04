package com.leetcode.solution;

import java.util.Arrays;

public class P53_MaximumSubarray {
    //Given an integer array nums, find the contiguous subarray (containing at least one number)
    // which has the largest sum and return its sum.
    //A subarray is a contiguous part of an array.

    //First try, no need to record i and j, only need the sum of max subarray.
//    public int maxSubArray(int[] nums) {
//        int[][] arr = new int[nums.length][nums.length];
//        int max = 0;
//        for(int i = 0; i < nums.length; i++){
//            for(int j = 0; j < nums.length; j++) {
//                if (i > j) {
//                    arr[i][j] = 0;
//                } else if (i == j) {
//                    arr[i][j] = i;
//                } else {
//                    arr[i][j] = arr[i][j - 1] + j;
//                }
//                max = Math.max(max, arr[i][j]);
//            }
//        }
//        return max;
//    }
        //问zhifei为什么加if判断？
        //
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            }
            Arrays.sort(dp);
            return dp[nums.length - 1];
        }

        //其他算法
}
