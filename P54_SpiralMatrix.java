package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lv Jiale on 3/23/2023.
 */
public class P54_SpiralMatrix {

    /*
    *
    * time: O(MN)
    * space: O(MN)
    * */
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int up = 0, down = matrix.length - 1, l = 0, r = matrix[0].length - 1;
            while(true){ //转四圈
                for(int i = l; i <= r; i++){ //从左到右遍历上边界
                    res.add(matrix[up][i]);
                }
                if(++up > down) break;
                for(int i = up; i <= down; i++){ //从上到下遍历右边界
                    res.add(matrix[i][r]);
                }
                if(--r < l) break;
                for(int i = r; i >= l; i--){ //从右到左遍历下边界
                    res.add(matrix[down][i]);
                }
                if(--down < up) break;
                for(int i = down; i >= up; i--){ //从下到上遍历左边界
                    res.add(matrix[i][l]);
                }
                if(++l > r) break;
            }
            return res;
        }
    }
}
