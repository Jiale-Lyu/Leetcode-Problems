package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/9/2023.
 */
public class P48_RotateImage {


    /*
    * 辅助数组
    * time: O(n^2)
    * space: O(n^2)
    *
    * */
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] res = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    res[i][j] = matrix[n - 1 - j][i]; //关键步骤
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = res[i][j];
                }
            }
        }
    }

}
