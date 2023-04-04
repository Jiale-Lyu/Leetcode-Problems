package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/31/2023.
 */
public class P463_IslandPerimeter {

    /*
    * dfs 递归
    * time: O(mn), m是网格的高度，n是宽度，每个格子至多会被遍历1遍
    * space: O(mn), 递归栈空间，最坏情况是O(mn)
    * */
    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int islandPerimeter(int[][] grid) {
            int res = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    //因为只有1个岛屿，所以dfs完直接返回
                    if(grid[i][j] == 1){
                        res = dfs(grid, i, j);
                        return res;
                    }
                }
            }
            return 0;
        }
        public int dfs(int[][] grid, int i, int j){
            //判断周长加1的情况
            if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0){
                return 1;
            }
            //判断是否是走过的元素！！
            if(grid[i][j] == 2){
                return 0;
            }
            int ans = 0;
            //走过的路赋值为2，产生误会，如果赋值为0，在算与0节点的边界时会多算周长！！
            grid[i][j] = 2;
            for(int[] dir : dirs){
                int x = i + dir[0], y = j + dir[1];
                ans += dfs(grid, x, y);
            }
            return ans;
        }
    }
}
