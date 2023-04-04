package com.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P217_ContainsDuplicate {
    //Given an integer array nums, return true if any value appears at least twice in the array,
    // and return false if every element is distinct.
    //Solution video: https://b23.tv/l8z1KzP

    //应该先想到两个数据结构
    //1. set 元素唯一
    //2. HashMap 计算次数

    //1. Sorting 排完序用一个变量辅助比较相邻两个元素是否相等
    //Time Complexity: O(NlogN)
    //Space Complexity: O(1)
//    public static boolean containsDuplicate(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return false;
//        }
//        Arrays.sort(nums); //TC: O(NlogN)
//        int prev = nums[0];
//        for(int i = 1; i < nums.length; i++){ //i从1开始
//            if(prev == nums[i]){
//                return true;
//            }else{
//                prev = nums[i];
//            }
//        }
//        return false;
//    }

    //2. Set
    // set.add(num) 如果num是set中的元素会返回false
    //Time Complexity: O(N)
    //Space Complexity: O(N)
//    public static boolean containsDuplicate(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return false;
//        }
//        HashSet<Integer> set = new HashSet<>();
//        for(int num : nums){
//            set.add(num);
//        }
//        return set.size() == nums.length ? false : true;
//    }

    // Set_2
//    public static boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int val : nums) {
//            if (!set.add(val)) {
//                return true;
//            }
//        }
//        return false;
//    }

    //3. HashMap
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1); //有这个数，这个数的次数加1
            }else{
                map.put(num, 1); //没有这个数，把这个数放入hashmap中
            }
        }
        for(int k : map.keySet()){
            if(map.get(k) > 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
