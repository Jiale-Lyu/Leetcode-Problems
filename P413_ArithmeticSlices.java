package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/6/2023.
 */
public class P413_ArithmeticSlices {


    /*
    * 滑动窗口
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        //滑动窗口
        public int numberOfArithmeticSlices(int[] nums) {
            int len = nums.length;
            if(len < 3) return 0;
            int n = 2;
            int res = 0;
            int preDiff = nums[1] - nums[0];
            for(int i = 2; i < len; i++){
                int curDiff = nums[i] - nums[i-1];
                //确保是等差数列，长度就加1
                if(curDiff == preDiff){
                    n++;
                }else{
                    //如果和前面不能构成等差数列，就计算前面等差数列的子区间的个数
                    res += (n-1)*(n-2) / 2;
                    n = 2;
                    preDiff = curDiff;
                }
            }
            //再算一次最后一个等差数列子数列的个数，如果最后不符合等差数列，相当于加0
            res += (n-1)*(n-2) / 2;
            return res;
        }
    }

    /*
    * 动态规划
    * time: O(n)
    * space: O(n)
    * */
    class Solution2 {
        //动态规划
        public int numberOfArithmeticSlices(int[] nums) {
            int len = nums.length;
            if(len < 3) return 0;
            int res = 0;
            int[] dp = new int[len];
            for(int i = 2; i < len; i++){
                if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
                    //dp[i]中存的是以nums[i]结尾的 长度大于3的 等差子序列的个数
                    dp[i] = dp[i-1] + 1;
                    res += dp[i];
                }
            }
            return res;
        }
    }
}
