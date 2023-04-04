package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lv Jiale on 2/22/2023.
 */
public class P15_3Sum {



    /*
    *
    * 外层循环1次，循环体中用左右双指针
    * time: O(n^2), 排序nlogn + 遍历n * 双指针n
    * space: O(1)
    *
    * */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            //先排序
            Arrays.sort(nums);
            for(int i = 0; i < n; i++){
                //如果这个数大于0， 加上后面的正数更大于0，推出循环
                if(nums[i] > 0){
                    break;
                }
                if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                int l = i + 1, r = n - 1; //左右指针
                while(l < r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]) l++;     //控制l，r不重复的while要放在sum==0的里面
                        while(l < r && nums[r] == nums[r - 1]) r--;     //不然例如case[0,0,0]就过不去
                        r--;
                        l++;
                    }else if(sum > 0){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
            return ans;
        }
    }
}
