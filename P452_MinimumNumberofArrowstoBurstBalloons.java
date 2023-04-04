package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 3/14/2023.
 */
public class P452_MinimumNumberofArrowstoBurstBalloons {


    /*
    *
    * time: O(nlogn)
    * space: O(logn)
    * */
     class Solution {
     public int findMinArrowShots(int[][] points) {
         if(points.length == 0){
             return 0;
         }
         int count = 1;
         Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1); //按右端点排序
         int end = points[0][1];
         for(int i = 0; i < points.length; i++){ //如果区间起点比end大，多加一支箭
             if(points[i][0] > end){
                 count++;
                 end = points[i][1];
             }
         }
         return count;
     }
 }

    class Solution2 {
        public int findMinArrowShots(int[][] points) {
            if(points.length == 0){
                return 0;
            }
            int count = 1;
            Arrays.sort(points, (a, b) -> a[0] > b[0] ? 1 : -1); //按左端点排序
            int end = points[0][1];
            for(int i = 0; i < points.length; i++){ //如果区间起点比end大，多加一支箭
                if(points[i][0] > end){
                    count++;
                    end = points[i][1];
                }else{ //比右端点排序多一个更新end的步骤
                    end = Math.min(end, points[i][1]);
                }
            }
            return count;
        }
    }
}
