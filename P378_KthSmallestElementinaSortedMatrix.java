package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 1/12/2023.
 */
public class P378_KthSmallestElementinaSortedMatrix {

    /*
    * 暴力解法
    * time: O(n^2logn)
    * space: O(n^2)
    * */
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[] sorted = new int[m * n];
            int index = 0;
            for(int[] row : matrix){
                for(int num : row){
                    sorted[index++] = num;
                }
            }
            Arrays.sort(sorted);
            return sorted[k - 1];
        }
    }


}
