package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/16/2023.
 */
public class P343_IntegerBreak {


    /*
    * dp
    * time: O(n^2)
    * space: O(n)
    * */
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for(int i = 2; i <= n; i++){
                for(int j = 1; j < i; j++){
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }

    /*
    * 记忆化递归
    * time: O(n^2)
    * space: O(n)
    *
    * */
     class Solution2 {
         Integer[] memo;
         public int integerBreak(int n) {
             memo = new Integer[n + 1];
             return dfs(n);
         }
         public int dfs(int n){
             if(n == 1){
                 return 1;
             }
             if(memo[n] != null){
                 return memo[n];
             }
             int res = 0;
             for(int i = 1; i < n; i++){ //以n=10为例，i：1~9
                 res = Math.max(res, Math.max(i * (n - i), i * dfs(n - i)));
             }
             memo[n] = res;
             return res;
         }
     }
}
