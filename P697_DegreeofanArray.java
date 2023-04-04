package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 1/15/2023.
 */
public class P697_DegreeofanArray {


    /*
    * hashmap
    * time: O(N)
    * space: O(N)
    * */
    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, int[]> map = new HashMap<>(); //哈希表，key存num，value是一个数组，这个数的个数，left和right下标位置
            int n = nums.length;
            for(int i = 0; i < n; i++){
                if(map.containsKey(nums[i])){
                    map.get(nums[i])[0]++; //个数加1
                    map.get(nums[i])[2] = i; //right下标
                }else{
                    map.put(nums[i], new int[]{1, i, i});
                }
            }
            int maxNum = 0, minLen = 0;
            for(Map.Entry<Integer, int[]> entry : map.entrySet()){
                int[] arr = entry.getValue();
                if(arr[0] > maxNum){
                    maxNum = arr[0];
                    minLen = arr[2] - arr[1] + 1;
                }else if(arr[0] == maxNum){
                    if(minLen > arr[2] - arr[1] + 1){
                        minLen = arr[2] - arr[1] + 1;
                    }
                }
            }
            return minLen;
        }
    }
}
