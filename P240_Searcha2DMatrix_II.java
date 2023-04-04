package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/12/2023.
 */
public class P240_Searcha2DMatrix_II {

    /*
    * 暴力解法，遍历整个matrix
    * time: O(m*n)
    * space: O(1)
    * */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for(int[] row : matrix){
                for(int element : row){
                    if(element == target){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /*
    * 二分查找法
    * 3个注意点 //
    * time: O(mlogn), 一次二分查找需要logn，最多进行m次
    * space: O(1)
    * */
    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            for(int[] row : matrix){
                int index = search(row, target);
                if(index >= 0){
                    return true;
                }
            }
            return false;
        }
        public int search(int[] nums, int target){
            int low = 0;
            int high = nums.length - 1;
            while(low <= high){ // <= 而不是 <
                int mid = (high - low) / 2 + low; //要 + low
                int num = nums[mid]; //注意不要直接用mid，而是nums[mid]
                if(num == target){
                    return mid;
                }else if(num > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            return -1;
        }
    }


    /*
    * z字查找法
    * time: O(m+n)
    * space: O(n)
    * */
    class Solution3 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length; //m, n是二维数组的行和列
            int x = 0, y = n - 1; //x, y分别是指针的行和列，从matrix右上角开始
            while(x < m && y >= 0){
                if(matrix[x][y] == target){
                    return true;
                }else if(matrix[x][y] > target){
                    y--; //横着向左移一列
                }else{
                    x++; //竖着向下移动一列
                }
            }
            return false;
        }
    }
}
