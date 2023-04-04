package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 2/8/2023.
 */
public class P88_MergeSortedArray {

    /*
    * 所有玩家都全力向前冲刺, 却不知道向后才是胜利之门。-《头号玩家》
    * time: O(m+n)
    * space: O(1)
    * */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //从nums1的末尾向前放nums1和nums2中的较大值
            int i = m + n - 1;
            m = m - 1;
            n = n - 1;
            while(n >= 0){
                //m < 0 说明原来的m <= 0, 说明nums1中没有数字，直接把nums2中所有都copy到nums1中
                if(m >= 0 && nums1[m] > nums2[n]){
                    nums1[i--] = nums1[m--];
                }else{
                    nums1[i--] = nums2[n--];
                }
            }
        }
    }

    /*
    * 用Arrays.sort()
    * t: O(nlogn)
    * s: O(logn)
    * */
    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for(int i = 0; i < n; i++){
                nums1[m+i] = nums2[i];
            }
            Arrays.sort(nums1);
        }
    }
}
