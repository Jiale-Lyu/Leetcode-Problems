package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/5/2023.
 */
public class P62_UniquePaths {

    /*
    * time: O(mn)
    * space: O(mn)
    * */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
            return dp[m-1][n-1];
        }
    }


    /*
    * 组合
    * time: O(m)
    * space: O(1)
    * */
    class Solution2 {
        public int uniquePaths(int m, int n) {
            long res = 1;
            //组合问题，从左上到右下需要移动m+n-2次，其中向下m-1次,向右n-1次
            //路径总数等于从m+n-2次中选择m-1次向下移动的方案，即组合数
            for(int i = n, j = 1; j < m; i++, j++){
                res = res * i / j;
            }
            return (int) res;
        }
    }
}
