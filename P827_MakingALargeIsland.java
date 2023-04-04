package com.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lv Jiale on 2/3/2023.
 */
public class P827_MakingALargeIsland {


    /*
    *
    * */
    class Solution {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n;
        //都要用的变量可以设成全局变量
        public int largestIsland(int[][] grid) {
            //先遍历1，记算每个岛屿的面积，并标记岛屿
            n = grid.length;
            int res = 0, idx = 2;
            Map<Integer, Integer> area = new HashMap<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1){
                        area.put(idx, calculateArea(idx, grid, i, j));
                        idx++;
                    }
                }
            }
            if(area.size() == 0) return 1; //全是岛屿，没有海洋
            //再遍历0，找到相邻两个最大岛屿的海洋格子
            //使用set去重，防止重复计算
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int sum = 0;
                    Set<Integer> set = new HashSet<>(); //去重
                    if(grid[i][j] == 0){
                        sum += 1;
                        for(int[] dir : dirs){
                            int x = i + dir[0], y = j + dir[1];
                            //判断邻居是否是岛屿，并能加到set中
                            if(x >=0 && x < n && y >= 0 && y < n && grid[x][y] != 0 && set.add(grid[x][y])){
                                sum += area.get(grid[x][y]);
                            }
                        }
                    }
                    res = Math.max(res, sum);
                }
            }
            //全是岛屿，没有海洋？
            return res == 0 ? area.get(2) : res;
        }

        //计算返回岛面积，并标记index
        public int calculateArea(int idx, int[][] grid, int i, int j){
            if(i < 0 || i == n || j < 0 || j == n || grid[i][j] != 1){
                return 0;
            }
            int sum = 0;
            if(grid[i][j] == 1){
                sum ++;
                grid[i][j] = idx;
                for(int[] dir : dirs){
                    int x = i + dir[0], y = j + dir[1];
                    sum += calculateArea(idx, grid, x, y);
                }
            }
            return sum;
        }
    }
}
