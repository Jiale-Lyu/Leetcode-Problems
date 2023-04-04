package com.leetcode.solution;

import java.util.HashMap;

public class P1_TwoSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //Solution video: https://b23.tv/SqXQqaI

        //1. Brute Force
        //N is the size of nums
        //Time Complexity: O(N^2)
        //Space Complexity: O(1)

//    public static int[] twoSum(int[] nums, int target) {
//        int[] ans = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    ans[0] = i;
//                    ans[1] = j;
//                    return ans;
//                }
//            }
//        }
//        return ans;

        //2. HashMap
        //N is the size of nums
        //Time Complexity: O(N)
        //Space Complexity: O(N)

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int diff = target - nums[j];
            if (map.containsKey(diff) && map.get(diff) != j) {
                ans[0] = j;
                ans[1] = map.get(diff);
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.print("[" + result[0] + "," + result[1] + "]");
    }
}
