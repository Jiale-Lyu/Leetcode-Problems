package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/31/2023.
 */
public class P200_NumberofIslands {

    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int numIslands(char[][] grid) {
            int count = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }
        //dfs把这个1相邻的所有1变成0
        public void dfs(char[][] grid, int i, int j){
            grid[i][j] = '0';
            for(int[] dir : dirs){
                int x = i + dir[0], y = j + dir[1];
                //注意判断条件, 不符合条件的continue跳过，‘0’是char不是int型！！
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'){
                    continue;
                }
                //符合条件的继续dfs，把相邻的1变成0
                dfs(grid, x, y);
            }
        }
    }
}
