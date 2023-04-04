package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/5/2023.
 */
public class P198_HouseRobber {

    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for(int i = 2; i <= n; i++){
                //偷不偷H(i-1)？
                //1. 偷H(i-1), nums[i-1] + dp[i-2]
                //2. 不偷H(i-1), dp[i-1]
                dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
            }
            return dp[n];
        }
    }

    /*
    * 优化空间
    * time: O(n)
    * space: O(1)
    * */
    class Solution2 {
        public int rob(int[] nums) {
            int cur = 0, pre = 0;
            //每次循环，计算偷到当前房子为止的最大金额
            for(int i : nums){
                //循环开始时，cur表示dp[k-1], pre表示dp[k-2]
                int temp = Math.max(cur, pre+i);
                pre = cur;
                cur = temp;
                //循环结束时，cur表示dp[k], pre表示dp[k-1]
            }
            return cur;
        }
    }

}


