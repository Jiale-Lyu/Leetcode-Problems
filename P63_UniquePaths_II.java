package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/19/2023.
 */
public class P63_UniquePaths_II {


    /*
    * dp
    * time: O(mn)
    * space: O(mn)
    * */
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m+1][n+1]; //padding +1下面不用判断是否出界
            dp[1][1] = 1;
            int res = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(obstacleGrid[i-1][j-1] == 1){ //dp和原数组会相差1
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] += dp[i-1][j] + dp[i][j-1]; //注意这里是+=，否则dp[1][1]为0
                    }
                }
            }
            return dp[m][n];
        }
    }
}
