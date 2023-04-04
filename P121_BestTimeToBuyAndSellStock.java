package com.leetcode.solution;

public class P121_BestTimeToBuyAndSellStock {
    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    //Solution video: https://b23.tv/SqyCNeI



        /*
        * 两个变量maxProfit, min分别记录当前最大利润和最小值
        * Dynamic Programming
        * Time complexity: O(N)
        * Space complexity: O(1)
        *
        * */
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        //same?
//        for(int i = 1; i < prices.length; i++){
//            if(prices[i] < min){
//                min = prices[i];
//            }else if(prices[i] - min > maxProfit){
//                maxProfit = prices[i] - min;
//            }
//        }
    return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }
}
