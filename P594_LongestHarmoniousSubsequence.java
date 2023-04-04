package com.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Lv Jiale on 1/6/2023.
 */
public class P594_LongestHarmoniousSubsequence {

    /*
    * 枚举法，滑动窗口
    * Arrays.sort() time: O(NlogN), 双指针遍历数组花费的时间为 O(2N)
    * time: O(NlogN)
    * space: O(1)
    *
    * */
    class Solution1 {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int l = 0;
            int res = 0;
            for(int r = 0; r < nums.length; r++){
                while(nums[r] - nums[l] > 1) l++; //左指针移到和右指针对应值相差小于等于1的位置
                if(nums[r] - nums[l] == 1){
                    res = Math.max(res, r - l + 1); //如果差值等于1，计算左右指针之间包含的数的个数
                }
            }
            return res;
        }
    }

    /*
    * Hashmap 统计每个元素出现的次数
    * time: O(n)
    * space: O(n)
    * */
    class Solution2 {
        public int findLHS(int[] nums) {
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            // for loop 把元素出现的次数存到hashmap中
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(int key : map.keySet()){
                if(map.containsKey(key + 1)){
                    res = Math.max(res, map.get(key) + map.get(key + 1));
                }
            }
            return res;
        }
    }

}
