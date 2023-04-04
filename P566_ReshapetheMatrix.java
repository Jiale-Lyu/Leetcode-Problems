package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/12/2023.
 */
public class P566_ReshapetheMatrix {


    /*
    * 用一维数组进行过渡
    * time: O(n^2)
    * space: O(n)
    * */
    class MySolution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if((r * c) != (mat.length * mat[0].length)){
                return mat;
            }
            int[][] newMat = new int[r][c];
            int n = 0;
            int[] nums = new int[r * c];
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[0].length; j++){
                    nums[n++] = mat[i][j];
                }
            }
            n = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    newMat[i][j] = nums[n++];
                }
            }
            return newMat;
        }
    }


    /*
    * 对于m*n 的矩阵，整数 x 映射回其在矩阵中的下标 i = x / n, j = x % n
    *
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;
            if(m * n != r * c){
                return mat;
            }
            int[][] ans = new int[r][c];
            for(int x = 0; x < m * n; x++){
                ans[x / c][x % c] = mat[x / n][x % n];
            }
            return ans;
        }
    }
}
