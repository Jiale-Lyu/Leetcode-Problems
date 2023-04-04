package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/27/2023.
 */
public class P542_01Matrix {


    /*
    * 图的广度优先
    * time: O(mn)
    * space: O(mn)
    *
    * */
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            //用一个二维数组来处理向四个方向走一步
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int[][] res = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();
            //第一层先把所有的0元素，加入队列
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(mat[i][j] == 0){
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            int cost = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int s = 0; s < size; s++){
                    int[] cur = queue.poll();
                    int i = cur[0], j = cur[1];
                    //遇到1，就将其distance赋值为上一层走完之后更新的cost
                    //同一层里的1的cost是一样的
                    if(mat[i][j] == 1){
                        res[i][j] = cost;
                    }
                    //取出的这个元素向四面八方走
                    for(int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        //验证走完一步之后的元素是有效的，并且没有走过
                        if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
                            queue.offer(new int[]{x, y});
                            visited[x][y] = true;

                        }
                    }
                }
                //每走完一层，cost加一
                cost++;
            }
            return res;
        }
    }
}
