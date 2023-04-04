package com.leetcode.solution;

public class P238_ProductofArrayExceptSelf {

    //两次循环，从前往后存左侧乘机，从后往前乘右侧乘积
    //Time complexity: O(N)
    //Space complexity: O(1) 输出数组不算进空间复杂度中
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        //ans[i]存储nums[i]元素左侧数的乘积
        for(int i = 1; i < nums.length; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        //R存储nums[i]右侧数的乘积
        //ans[i]存储nums[i]左右元素的乘积
        int R = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }

}
