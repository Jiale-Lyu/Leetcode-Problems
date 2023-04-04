package com.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lv Jiale on 1/8/2023.
 */
public class P128_LongestConsecutiveSequence {

    /*
    * 哈希表
    * time: O(N)
    * space: O(N)
    * */
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            //先用hashset去重
            for(int num : nums){
                num_set.add(num);
            }
            int longestStreak = 0;
            for(int num : num_set){
                //如果这个数的前一个数在set中，那么不进入内循环，跳过这个数
                if(!num_set.contains(num - 1)){
                    int currentStreak = 1;
                    int currentNum = num;
                    while(num_set.contains(currentNum + 1)){ //找从这个数开头的连续数，更新streak的长度
                        currentNum++;
                        currentStreak++;
                    }
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
            return longestStreak;
        }
    }
}
