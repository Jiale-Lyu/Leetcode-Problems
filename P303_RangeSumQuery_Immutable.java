package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/5/2023.
 */
public class P303_RangeSumQuery_Immutable {

    /*
    * 前缀和
    * time: O(n)
    * space: O(n)
    * */
    class NumArray {
        int[] sums;
        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for(int i = 0; i < n; i++){
                sums[i+1] = nums[i] + sums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
