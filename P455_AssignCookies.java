package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 2/15/2023.
 */

/*
* 贪心算法
* time: O(nlogn + mlogm)
* space: O(logn + logm)
* */
public class P455_AssignCookies {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int m = g.length, n = s.length;
            int count = 0;
            for(int i = 0, j = 0; i < m && j < n; i++, j++){
                while(j < n && g[i] > s[j]){
                    j++;
                }
                if(j < n){
                    count++;
                }
            }
            return count;
        }
    }
}
