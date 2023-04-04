package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/22/2023.
 */
public class P11_ContainerWithMostWater {


    /*
    * 双指针
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int l = 0, r = height.length - 1;
            //mine, 可以改成下面的优化while loop
            while(l < r){
                int min = Math.min(height[l], height[r]);
                int area = min * (r - l);
                max = Math.max(max, area);
                if(height[l] > height[r]){
                    r--;
                }else{
                    l++;
                }
            }
            // while(l < r){
            //     max = height[l] < height[r] ?
            //     Math.max(max, (r - l) * height[l++]) :
            //     Math.max(max, (r - l) * height[r--]);
            // }
            return max;
        }
    }
}
