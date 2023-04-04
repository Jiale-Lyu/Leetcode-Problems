package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/16/2023.
 */
public class P91_DecodeWays {

    /*
    * dp
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for(int i = 1; i <= n; i++){
                if(s.charAt(i - 1) != '0'){
                    dp[i] += dp[i - 1];
                }

                if(i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26){
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }



    /*
    * 记忆化搜索dfs
    *
    * */
     class Solution2 {
         Integer[] memo;
         public int numDecodings(String s) {
             int n = s.length();
             memo = new Integer[n + 1];
             return dfs(s, n);
         }
         public int dfs(String s, int n){
             if(n == 0){
                 return 1; //比如dfs(22, 2) 可分为[2],[2] 和[],[22]，后者走这个分支，返回1，算1种分法
             }
             if(n == 1){
                 return s.charAt(0) == '0' ? 0 : 1; //s.charAt(n-1)
             }
             if(memo[n] != null){
                 return memo[n];
             }
             int res = 0;
             char x = s.charAt(n - 1), y = s.charAt(n - 2);
             int num = (y - '0') * 10 + (x - '0');

             if(x != '0'){ //合法的1位数
                 res += dfs(s, n - 1);
             }

             if(num >=10 && num <= 26){ //合法的两位数
                 res += dfs(s, n - 2);
             }
             memo[n] = res;
             return res;
         }
     }


}
