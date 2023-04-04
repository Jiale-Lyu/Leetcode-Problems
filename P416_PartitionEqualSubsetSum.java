package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 3/19/2023.
 */
public class P416_PartitionEqualSubsetSum {

    /*
    * 0-1背包问题
    * 一维数组
    * time: O(NC)这里 N 是数组元素的个数，C 是数组元素的和的一半
    * space: O(C)
    * */
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if(sum % 2 != 0 || n == 1) return false; //sum是奇数或者nums中只有一个数
            //当限重是index时,能获取的最大重量
            int[] dp = new int[sum / 2 + 1];
            for(int i = 0; i < n; i++){
                for(int j = sum / 2; j >= nums[i]; j--){ //j从后往前遍历，保证前一轮i-1的各个dp[j]值不被覆盖
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]); //dp[j]表示大小为j的背包能放的最大sum值
                }
            }
            return dp[sum / 2] == sum / 2;
        }
    }

    /*
    * 二维数组
    * time: O(NC)这里 N 是数组元素的个数，C 是数组元素的和的一半
    * space: O(NC)
    * */
     class Solution2 {
         public boolean canPartition(int[] nums) {
             int sum = Arrays.stream(nums).sum();
             int n = nums.length;
             if(sum % 2 != 0 || n == 1) return false;
             int target = sum / 2;
             boolean[][] dp = new boolean[n][target + 1];
             if(nums[0] <= target){ //只有第一个数能选的时候，只有一个容量刚好等于第一个数的背包能被刚好装满
                 dp[0][nums[0]] = true;
             }
             for(int i = 1; i < n; i++){ //从第二个数开始循环
                 for(int j = 0; j <= target; j++){
                     dp[i][j] = dp[i - 1][j]; //先把前一个数的dp抄过来再更新
                     if(nums[i] == j){ //nums[i]这个数恰好等于背包的大小，那么只选这一个数就能刚好装满背包
                         dp[i][j] = true;
                         continue;
                     }
                     if(nums[i] < j){
                         dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                     }
                 }
             }
             return dp[n - 1][target];
         }
     }
}
