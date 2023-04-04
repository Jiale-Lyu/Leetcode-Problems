package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lv Jiale on 3/8/2023.
 */
public class P417_PacificAtlanticWaterFlow {


    /*
    * dfs
    * time: O(MN)
    * space: O(MN)
    * */
    class Solution {
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> res = new ArrayList<>();
            int rows = heights.length, cols = heights[0].length;
            boolean[][] pacific = new boolean[rows][cols];
            boolean[][] atlantic = new boolean[rows][cols];

            for(int i = 0; i < cols; i++){
                dfs(heights, 0, i, Integer.MIN_VALUE, pacific); //第一行，pacific从上到下流
                dfs(heights, rows - 1, i, Integer.MIN_VALUE, atlantic); //最后一行，atlantic从下到上流
            }
            for(int i = 0; i < rows; i++){
                dfs(heights, i, 0, Integer.MIN_VALUE, pacific); //第一列，pacific从左到右流
                dfs(heights, i, cols - 1, Integer.MIN_VALUE, atlantic); //最后一列，atlantic从右到左流
            }
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(pacific[i][j] && atlantic[i][j]){
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
            return res;
        }

        public void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean){ //能流到的格子写成true
            if(i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) return;
            if(heights[i][j] < prev || ocean[i][j]) return;
            ocean[i][j] = true;

            for(int[] d : dir){
                dfs(heights, i + d[0], j + d[1], heights[i][j], ocean);
            }
        }

    }

}
