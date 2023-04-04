package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/26/2023.
 */
public class P74_Searcha2DMatrix {

    /*
    * 二分法
    * 2D 转1D array： int mid = matrix[midIndex / col][midIndex % col];
    * time: O(logmn) m和n是matrix的行和列数
    * space: O(1)
    * */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int col = matrix[0].length;
            int left = 0, right = matrix.length * col - 1;
            while(left <= right){
                int midIndex = left + (right - left) / 2;
                int mid = matrix[midIndex / col][midIndex % col];
                if(mid == target){
                    return true;
                }else if(mid < target){
                    left = midIndex + 1;
                }else{
                    right = midIndex - 1;
                }
            }
            return false;
        }
    }
}
