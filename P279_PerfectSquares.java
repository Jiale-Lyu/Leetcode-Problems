package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 3/17/2023.
 */
public class P279_PerfectSquares {

    /*
    * 记忆化递归
    * time: O(n^2)
    * space: O(n)
    * */
    class Solution {
        Integer[] memo;
        public int numSquares(int n) {
            memo = new Integer[n + 1];
            return dfs(n);
        }
        public int dfs(int n){
            if(n == 0){
                return 0;
            }
            if(memo[n] != null){
                return memo[n];
            }
            int res = Integer.MAX_VALUE;
            for(int i = 1; i * i <= n; i++){
                res = Math.min(res, dfs(n - i * i) + 1);
            }
            memo[n] = res;
            return res;
        }
    }

    /*
    * dp
    * time: O(n^2)
    * space: O(n)
    * */
     class Solution2 {
         public int numSquares(int n) {
             int[] dp = new int[n + 1];
             Arrays.fill(dp, Integer.MAX_VALUE);
             dp[0] = 0;
             for(int i = 1; i <= n; i++){
                 for(int j = 1; j * j <= i; j++){ //枚举出来1~i中的所有完全平方数
                     dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                 }
             }
             return dp[n];
         }
     }
// 解法参考：https://leetcode.cn/problems/perfect-squares/solutions/159147/\xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--51/
}
