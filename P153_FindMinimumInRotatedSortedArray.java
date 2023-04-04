package com.leetcode.solution;

public class P153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        //My code:
//        int left = 0;
//        int right = nums.length - 1;
//        int mid = (left + right) / 2;
//        do {
//            if(nums[left] > nums[mid]){
//                right = mid;
//                mid = (left + right) / 2;
//            }else if(nums[right] < nums[mid]){
//                left = mid;
//                mid = (left + right) / 2;
//            }else{
//                return nums[0];
//            }
//        }while(mid != left && mid != right);
//        return nums[left] < nums[right] ? nums[left] : nums[right];
        //return Math.min(nums[left], nums[right]);

        //正常情况下前面的数一定比右边的小，nums[mid] < nums[r], 如果比右边的大了，说名交界在右边的范围
        // Time Complexity: O(logN)
        //Space Complexity: O(1)???
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int pivot = (low + high) / 2;
            if(nums[pivot] < nums[high]){
                high = pivot;
            }else{
                low = pivot + 1;
            }
        }
        return nums[low]; //循环结束时low==high
        //return nums[high];
    }
}
