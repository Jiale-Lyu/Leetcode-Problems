package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 2/5/2023.
 */
public class P213_HouseRobber_II {

    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 0) return 0;
            if(nums.length == 1) return nums[0];
            //环转化为两个单排问题，Math.max(不偷第一户, 不偷第n户)
            //Arrays.copyOfRange(nums, from, to) 截取nums下标[from, to)
            return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)), myRob(Arrays.copyOfRange(nums, 1, nums.length)));
        }
        public int myRob(int[] nums){
            int pre = 0, cur = 0;
            for(int num : nums){
                int tmp = Math.max(cur, pre + num);
                pre = cur;
                cur = tmp;
            }
            return cur;
        }
    }
}
