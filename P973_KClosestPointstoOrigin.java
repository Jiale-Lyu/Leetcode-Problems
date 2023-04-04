package com.leetcode.solution;

import java.util.PriorityQueue;

/**
 * Created by Lv Jiale on 3/5/2023.
 */
public class P973_KClosestPointstoOrigin {


    /*
    * 最大堆
    * time：O(nlogk)
    * space: O(k)
    * */
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                    (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
            );
            for(int[] point : points){
                pq.offer(point);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            int[][] res = new int[k][2];
            int i = 0;
            for(int[] point : pq){
                res[i++] = point;
            }
            return res;
        }
    }
}
