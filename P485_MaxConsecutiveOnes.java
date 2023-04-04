package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/12/2023.
 */
public class P485_MaxConsecutiveOnes {

    /*
    * time: O(n)
    * space: O(1)
    * */
    class MySolution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int count = 0;
            int ans = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 1){
                    count++;
                    ans = Math.max(ans, count);
                }else{
                    count = 0;
                }
            }
            return ans;
        }
    }

}
