package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/30/2023.
 */
public class P136_SingleNumber {

    /*
    * 异或交换律，相同的数字异或为0，一个数字异或0值不变
    * */
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            if(nums.length > 1){
                for(int i = 1; i < nums.length; i++){
                    //a^b^a=a^a^b=b
                    ans = ans ^ nums[i];
                }
            }
            return ans;
        }
    }
    /*
    * hashmap, 存num和出现的次数
    * time: O(n)
    * space: O(n)
    */
}
