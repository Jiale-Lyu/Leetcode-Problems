package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lv Jiale on 3/15/2023.
 */
public class P56_MergeIntervals {

    /*
    * 我的方法
    * time: O(nlogn)
    * space: O(logn)
    * */
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, new Comparator<int[]>(){ //按左端点排序
                public int compare(int[] a, int[] b){
                    if(a[0] > b[0]){
                        return 1;
                    }else if(a[0] < b[0]){
                        return -1;
                    }else
                        return 0;
                }
            });
            int len = intervals.length;
            for(int i = 0; i < len; i++){
                int left = intervals[i][0];
                int right = intervals[i][1];
                while(i + 1 < len && intervals[i + 1][0] <= right){
                    right = Math.max(right, intervals[i+1][1]);
                    i++;
                }
                res.add(new int[]{left, right});
            }
            return res.toArray(new int[0][]);
        }
    }

    /*
    * 优化：
    * time: O(nlogn)
    * space: O(logn)
    * */
    class Solution2 {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, (a, b)-> a[0] - b[0]); //按左端点排序
            for(int i = 0; i < intervals.length; i++){
                int L = intervals[i][0], R = intervals[i][1];
                if(res.size() == 0 || res.get(res.size() - 1)[1] < L){
                    res.add(new int[]{L, R});
                }else{
                    res.get(res.size() - 1)[1] = Math.max(R, res.get(res.size() - 1)[1]); //如果新的左端点<=res里最后一个的右端点，就更新res中最后一个的右端点
                }
            }
            return res.toArray(new int[0][]);
        }
    }
}
