package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/22/2023.
 */
public class P55_JumpGame {


    /*
    * 贪心算法
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public boolean canJump(int[] nums) {
            int goal = nums.length - 1;
            for(int i = nums.length - 2; i >= 0; i--){
                if(nums[i] + i >= goal){
                    goal = i;
                }
            }
            return goal == 0;
        }
    }

    /*
    * 自己做出的dp
    *
    * */
    class Solution2 {
        public boolean canJump(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[nums.length - 1] = true;
            for(int i = nums.length - 2; i >= 0; i--){
                for(int j = 0; j < nums[i]; j++){
                    if(dp[i + j + 1] == true){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }
    }
}
