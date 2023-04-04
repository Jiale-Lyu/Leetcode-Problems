package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/8/2023.
 */
public class P167_TwoSum_II_InputArrayIsSorted {
    /*
    * 左右双指针
    * t：O(n)
    * s: O(1)
    * */
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while(left != right){
                if(numbers[left] + numbers[right] == target){
                    break;
                }else if(numbers[left] + numbers[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
            return new int[]{left+1, right+1};
        }
    }
}
