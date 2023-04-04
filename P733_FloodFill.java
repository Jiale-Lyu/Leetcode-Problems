package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/29/2023.
 */
public class P733_FloodFill {

    /*
    * bfs
    * time:O(mn)
    * space: O(mn)
    * */

    class Solution {
        //四个方向
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int curColor = image[sr][sc];
            if(curColor == color){
                return image;
            }
            int m = image.length, n = image[0].length;
            Queue<int[]> queue = new LinkedList<>();
            // boolean[][] used = new boolean[m][n];
            //本题used意义不大，可以重复赋值
            queue.offer(new int[]{sr, sc});
            image[sr][sc] = color;
            // used[sr][sc] = true;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int[] dir : dirs){
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    // if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == curColor && !used[x][y]){
                    if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == curColor){
                        image[x][y] = color;
                        // used[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }

            }
            return image;
        }
    }

    /*
    * dfs
    * time:O(mn)
    * space: O(mn)
    * */
    class Solution2 {
        //四个方向
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int curColor = image[sr][sc]; //要记下初始的image[sr][sc]的color
            if(curColor != color){
                dfs(image, sr, sc, curColor, color);
            }
            return image;
        }
        public void dfs(int[][] image, int x, int y, int curColor, int color) {
            if(image[x][y] == curColor){
                image[x][y] = color;
                for(int[] dir : dirs){
                    int i = dir[0] + x, j = dir[1] + y;
                    if(i >= 0 && i < image.length && j >= 0 && j < image[0].length){
                        dfs(image, i, j, curColor, color);
                    }
                }
            }
        }
    }
}
