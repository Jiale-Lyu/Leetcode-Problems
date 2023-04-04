package com.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lv Jiale on 3/23/2023.
 */
public class P73_SetMatrixZeroes {


    /*
    *
    * time: O(mn)
    * space: O(1)
    * */
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean row0_flag = false, col0_flag = false;
            for(int j = 0; j < n; j++){ //第一行是否有0
                if(matrix[0][j] == 0){
                    row0_flag = true;
                    break;
                }
            }
            for(int i = 0; i < m; i++){ //第一列是否有0
                if(matrix[i][0] == 0){
                    col0_flag = true;
                    break;
                }
            }
            for(int i = 1; i < m; i++){ //用第一行和第一列记录这列或这行是否有0
                for(int j = 1; j < n; j++){
                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for(int i = 1; i < m; i++){ //如果行首或列首是0，就置0
                for(int j = 1; j < n; j++){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
            if(row0_flag){
                for(int j = 0; j < n; j++){ //第一行置0
                    matrix[0][j] = 0;
                }
            }
            if(col0_flag){
                for(int i = 0; i < m; i++){ //第一列置0
                    matrix[i][0] = 0;
                }
            }
        }
    }

    /*
    *
    * time: O(mn)
    * space: O(m + n)
    * */
    class Solution2 {
        public void setZeroes(int[][] matrix) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(matrix[i][j] == 0){
                        row.add(i);
                        col.add(j);
                    }
                }
            }
            for(int r : row){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[r][j] = 0;
                }
            }
            for(int c : col){
                for(int i = 0; i < matrix.length; i++){
                    matrix[i][c] = 0;
                }
            }

            // for(int i = 0; i < matrix.length; i++){
            //     for(int j = 0; j < matrix[0].length; j++){
            //         if(row.contains(i) || col.contains(j)) matrix[i][j] = 0;
            //     }
            // }
        }
    }
}
