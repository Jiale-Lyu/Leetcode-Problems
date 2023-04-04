package com.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Lv Jiale on 1/13/2023.
 */
public class P645_SetMismatch {

    /*
    * 排序
    * time: O(nlogn)
    * space: O(logn)
    * */
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int[] errorNums = new int[2];
            int prev = 0;
            int n = nums.length;
            Arrays.sort(nums);
            for(int i = 0; i < n; i++){
                if(nums[i] == prev){ //如果与前一个数相等，就是重复的数
                    errorNums[0] = prev;
                }else if(nums[i] - prev > 1){ //如果与前一个数相差大于1，就是缺少的数
                    errorNums[1] = prev + 1;
                }
                prev = nums[i];
            }
            if(nums[n - 1] != n){
                errorNums[1] = n;
            }
            return errorNums;
        }
    }


    /*
    * HashMap，统计每个数字出现的次数，出现两次的是重复数字，遍历1-n,没有出现的是缺失的数字
    * time: O(n)
    * space: O(n)
    * */
    class Solution2 {
        public int[] findErrorNums(int[] nums) {
            int[] ans = new int[2];
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
//            我的for循环：
//            for(int i = 0; i < n; i++){
//                if(map.get(nums[i]) != 1){
//                    ans[0] = nums[i];
//                }
//                if(!map.containsKey(i + 1)){
//                    ans[1] = i + 1;
//                }
//            }
//            题解for循环：
            for(int i = 1; i <= n; i++){
                int count = map.getOrDefault(i, 0);
                if(count == 2){
                    ans[0] = i;
                }else if(count == 0){
                    ans[1] = i;
                }
            }
            return ans;
        }
    }

}
