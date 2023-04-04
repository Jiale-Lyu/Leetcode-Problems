package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/9/2023.
 */
public class P746_MinCostClimbingStairs {

    /*
    * dp
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int size = cost.length;
            int[] minCost = new int[size]; //到达第i级台阶顶部的最小花费
            minCost[0] = 0;
            minCost[1] = Math.min(cost[0], cost[1]);
            for(int i = 2; i < size; i++){
                minCost[i] = Math.min(minCost[i - 1] + cost[i], minCost[i - 2] + cost[i - 1]);
            }
            return minCost[size - 1];
        }
    }
}
