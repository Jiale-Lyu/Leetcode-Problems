package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/18/2023.
 */
public class P1143_LongestCommonSubsequence {

    /*
    * 最长公共子序列，dp
    * 动态规划也是有套路的：单个数组或者字符串要用动态规划时，可以把动态规划 dp[i] 定义为 nums[0:i] 中想要求的结果；
    * 当两个数组或者字符串要用动态规划时，可以把动态规划定义成两维的 dp[i][j] ，其含义是在 A[0:i] 与 B[0:j] 之间匹配得到的想要的结果。
    * time: O(nm)
    * space: O(nm)
    * */
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++){ //i==0 或者j==0表示一个字符串与空字符串的最大子序列长度，为0
                for(int j = 1; j <= n; j++){
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1; //两个字符串中分别截止到i,j的前一个字符的最长子序列 + 1
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
