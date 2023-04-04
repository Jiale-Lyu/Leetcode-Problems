package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/27/2023.
 */
public class P34_FindFirstandLastPositionofElementinSortedArray {



    /*
    *     两次二分，第一次二分查找第一个>=target的位置，第二次二分查找最后一个<=target的位置
    * time: O(logn)
    * space: O(1)
    *
    * */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums.length == 0){
                return new int[]{-1, -1};
            }
            int l = 0, r = nums.length - 1;
            //查找元素开始的位置
            while(l < r){
                int mid = l + (r - l) /2;
                if(nums[mid] >= target){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            if(nums[l] != target){
                return new int[]{-1, -1};
            }
            int L = r;
            l = 0; r = nums.length - 1;
            //查找元素结束的位置
            while(l < r){
                int mid = l + (r - l + 1) / 2; //当l=mid时，mid的取值要加1，否则会进入死循环
                if(nums[mid] <= target){
                    l = mid;
                }else{
                    r = mid - 1;
                }
            }
            return new int[]{L, r};
        }
    }
}
