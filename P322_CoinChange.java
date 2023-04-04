package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 3/19/2023.
 */
public class P322_CoinChange {

    /*
    * 完全背包
    * 一种面额的硬币可以拿多次
    * time: O(kn) k为币值个数，n为金额
    * space: O(n)
    *
    * */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp, amount+1); //相当于初始化为正无穷
            dp[0] = 0; //amount为0的时候不需要coin就能达到
            for(int i = 1; i <= amount; i++){
                for(int j = 0; j < coins.length; j++){
                    if(i - coins[j] < 0){ //amount小于硬币的面值
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
            //如果是amount+1说明amount不能由任何硬币的组合得到
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
