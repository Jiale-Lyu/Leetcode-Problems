package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/15/2023.
 */
public class P766_ToeplitzMatrix {

    /*
    * 遍历
    * time: O(n^2)
    * space: O(1)
    * */
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for(int i = 1; i < matrix.length; i++){
                for(int j = 1; j < matrix[0].length; j++){
                    if(matrix[i][j] != matrix[i - 1][j - 1]){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
