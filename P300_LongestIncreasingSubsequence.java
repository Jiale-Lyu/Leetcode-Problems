package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 3/17/2023.
 */
public class P300_LongestIncreasingSubsequence {



    /*
    *
    * time: O(n^2)
    * space: O(n)
    * */
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(nums[j] < nums[i]){ //找在i之前的且比i小的dp最大值 + 1
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int res = 0;
            for(int i = 0; i < n; i++){
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         for(int i = 0; i < n; i++){
//             int max = 1;
//             for(int j = 0; j < i; j++){
//                 if(nums[j] < nums[i]){
//                     max = Math.max(max, dp[j] + 1);
//                 }
//             }
//             dp[i] = max;
//         }
//         int res = 0;
//         for(int i = 0; i < n; i++){
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }
}
