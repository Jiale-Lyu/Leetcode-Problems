package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/15/2023.
 */
public class P287_FindtheDuplicateNumber {

    /*
    * You must solve the problem without modifying the array nums and uses only constant extra space.
    * cannot use sort();
    * */

    /*
    * 二分法，计算个数
    * time: O(nlog n)
    * space: O(1)
    * */
    class Solution {
        public int findDuplicate(int[] nums) {
            int l = 1, r = nums.length - 1;
            while(l < r){
                int mid = (l + r) / 2;
                int count = 0;
                //nums中小于等于mid的数的个数
                for(int num : nums){
                    if(num <= mid){
                        count++;
                    }
                }
                if(count > mid){
                    r = mid; //搜索区间[l, mid]
                }else{
                    l = mid + 1; //搜索区间[mid+1, r]
                }
            }
            return l;
        }
    }
}
