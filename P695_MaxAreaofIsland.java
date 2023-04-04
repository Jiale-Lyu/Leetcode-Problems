package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/31/2023.
 */
public class P695_MaxAreaofIsland {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int n = dfs(grid, i, j, 0);
//                    System.out.println(n);
                    res = Math.max(res, n);
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int i, int j, int area){
        grid[i][j] = 2;
        area++;
        System.out.println("area++:"+ area);
        for(int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                area = dfs(grid, x, y, area);
            }
        }
        System.out.println("return area:"+ area);
        return area;
    }
    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        P695_MaxAreaofIsland x = new P695_MaxAreaofIsland();
        x.maxAreaOfIsland(grid);
    }


    /*
    * dfs答案
    * */
    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    // 下面的写法是错的，因为dfs了两遍
                    // res = res >= dfs(grid, i, j)? res: dfs(grid, i, j);
                    res = Math.max(res, dfs(grid, i, j));

                }
            }
            return res;
        }
        public int dfs(int[][] grid, int i, int j){
            //dfs里先判断，不符合的元素直接返回0
            if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] != 1){
                return 0;
            }
            //是1的元素就定义一个area，并且加上每个邻居，邻居的邻居...
            grid[i][j] = 2;
            int area = 1;
            for(int[] dir : dirs){
                int x = i + dir[0], y = j + dir[1];
                area += dfs(grid, x, y);
            }
            return area;
        }
    }


 /*
 * dfs我的答案
 * */
    class Solution2 {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 1){
                        res = Math.max(res, dfs(grid, i, j, 0));
                    }
                }
            }
            return res;
        }
        public int dfs(int[][] grid, int i, int j, int area){
            grid[i][j] = 2;
            area++;
            for(int[] dir : dirs){
                int x = i + dir[0], y = j + dir[1];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                    //更新area的值！！！，如果只执行递归不更新area的值，递归返回来还是之前area的值。（1，2，3，3，2，1）
                    area = dfs(grid, x, y, area);
                }
            }
            return area;
        }
    }
}

