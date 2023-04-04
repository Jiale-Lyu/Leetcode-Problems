package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/1/2023.
 */
public class P33_SearchinRotatedSortedArray {


    /*
    * 只有在顺序区间内才可以通过区间两端的数值判断target是否在其中。
    * time: O(logn)
    * space: O(1)
    * */
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == target){
                    return mid;
                }
                if(nums[left] <= nums[mid]){ //左半边是顺序的
                    if(nums[left] <= target && target < nums[mid]){ //注意等号
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }else{ //右半边是顺序的
                    if(nums[mid] < target && target <= nums[right]){ //注意等号
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
