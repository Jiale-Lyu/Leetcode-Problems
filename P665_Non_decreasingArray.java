package com.leetcode.solution;

/**
 * Created by Lv Jiale on 4/4/2023.
 */
public class P665_Non_decreasingArray {


    /*
    * 贪心的策略，在遍历时，每次需要看连续的三个元素，也就是瞻前顾后，遵循以下两个原则：
      1. 需要尽可能不放大nums[i + 1]，这样会让后续非递减更困难；
      2. 如果缩小nums[i]，但不破坏前面的子序列的非递减性；

    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public boolean checkPossibility(int[] nums) {
            if(nums.length == 1){
                return true;
            }
            boolean flag = nums[0] <= nums[1] ? true : false; //第1位就比第2位大，1次机会用完了，后面不能再用了，flag置为false
            for(int i = 1; i < nums.length - 1; i++){ //瞻前顾后，前后都留出1个位置
                if(nums[i] > nums[i + 1]){ //出现递减
                    if(flag){ //如果还有机会修改
                        if(nums[i + 1] >= nums[i - 1]){ //修改方案1
                            nums[i] = nums[i + 1];
                        }else{
                            nums[i + 1] = nums[i]; //修改方案2
                        }
                        flag = false; //用掉唯一的机会
                    }else{
                        return false; //没有机会，直接结束
                    }
                }
            }
            return true;
        }
    }

// 瞻前顾后：
// https://leetcode.cn/problems/non-decreasing-array/solutions/594905/yi-ding-yao-rang-ni-nong-dong-wei-shi-ya-u9te/?orderBy=most_votes
}
