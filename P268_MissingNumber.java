package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 2/1/2023.
 */
public class P268_MissingNumber {

    /*
    * 排序
    * time：O(NlogN)
    * space: O(1ogN)
    * */
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            for(int i = 0; i < n; i++){
                if(i != nums[i]){
                    return i;
                }
            }
            return n;
        }
    }


    /*
    * 异或
    * time: O(n)
    * space: O(1)
    * */
    class Solution2 {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int ans = 0;
            //异或两轮，只有缺失的数只出现过一次，其他数异或两次都变成0了
            for(int i = 0; i <=n; i++) ans ^= i;
            for(int i : nums) ans ^= i;
            return ans;
        }
    }

    /*
    * 做差法
    * time: O(n)
    * space: O(1)
    * */
    class Solution3 {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum = (1 + n) * n / 2;
            for(int i = 0; i < n; i++) sum -= nums[i];
            return sum;
        }
    }

    /*
    * 数组哈希
    *  time: O(n)
    * space: O(n)
    * */
    class Solution4 {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            boolean[] hash = new boolean[n + 1];
            //遍历nums中每个数，在hash[]中标为true
            for(int i = 0; i < n; i++) hash[nums[i]] = true;
            //遍历1~n，返回不是true的
            for(int i = 0; i < n; i++){
                if(!hash[i]){
                    return i;
                }
            }
            return n;
        }
    }
}
