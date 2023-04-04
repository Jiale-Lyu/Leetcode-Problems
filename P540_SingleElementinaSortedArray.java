package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/26/2023.
 */
public class P540_SingleElementinaSortedArray {

    /*
    * 二分法
    * n^n = 0 (异或）
    * n^0 = n
    * time: O(logn)
    * space: O(1)
    * */
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int l = 0, r = nums.length - 1;
            while(l < r){
                int mid = l + (r - l) / 2;
                //^异或，当mid是奇数时，mid^1 = mid-1
                //当mid是偶数时，mid^1 = mid+1
                if(nums[mid] == nums[mid ^ 1]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            return nums[l];
        }
    }


    /*
    * 二分法
    * 由于只出现1次的元素所在的下标x的左边有偶数个元素，所以x一定是偶数。可以在偶数下标范围内二分查找。
    * time：O(logn)
    * space: O(1)
    * */
    class Solution2 {
        public int singleNonDuplicate(int[] nums) {
            int l = 0, r = nums.length - 1;
            while(l < r){
                int mid = l + (r - l) / 2;
                //让mid的下标是偶数
                //偶数&1是0，奇数&1是1
                mid -= mid & 1;
                if(nums[mid] == nums[mid + 1]){
                    l = mid + 2;
                }else{
                    r = mid;
                }
            }
            return nums[l];
        }
    }
}
