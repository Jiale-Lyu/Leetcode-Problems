package com.leetcode.solution;

/**
 * Created by Lv Jiale on 4/3/2023.
 */
public class P122_BestTimetoBuyandSellStock_II {



    /*
    * 贪心
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int maxProfit(int[] prices) {
            int res = 0;
            for(int i = 1; i < prices.length; i++){
                res += Math.max(prices[i] - prices[i-1], 0); //贪心算法，只考虑今天和昨天，上涨了就买，没涨就不买
            }
            return res;
        }
    }
}
