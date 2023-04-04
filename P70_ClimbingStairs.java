package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/5/2023.
 */
public class P70_ClimbingStairs {

    /*
    * dp
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }

    /*
    * time: O(n)
    * space: O(1)
    * */
    class Solution2 {
        public int climbStairs(int n) {
            if(n <= 2){
                return n;
            }
            //因为只需要记录前两个数的值，所以不用数组来存，而是用2个变量更省空间
            int pre2 = 1, pre1 = 2;
            for(int i = 2; i < n; i++){
                int cur = pre1 + pre2;
                pre2 = pre1;
                pre1 = cur;
            }
            return pre1;
        }
    }

}
