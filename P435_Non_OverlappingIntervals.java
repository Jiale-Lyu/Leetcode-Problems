package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 3/13/2023.
 */
public class P435_Non_OverlappingIntervals {



    /*
    * 区间+贪心算法
    * time: O(nlogn)
    * space: O(logn)
    * */
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int count = 0;
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //按区间左端点从小到大排序
            int end = intervals[0][1]; //取第一个区间的右端点为end
            for(int i = 1; i < intervals.length; i++){
                if(intervals[i][0] < end){ //如果重合，必须要移除一个，所以count++
                    count++;
                    //更新end，保留右端点较小的区间，移除右端点较大的区间，可以使移除的区间最少
                    end = Math.min(end, intervals[i][1]);
                }else{ //不重合就不用移除，直接更新end
                    end = intervals[i][1];
                }
            }
            return count;
        }
    }

}
