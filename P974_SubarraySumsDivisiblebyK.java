package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 2/17/2023.
 */
public class P974_SubarraySumsDivisiblebyK {

    /*
    * 前缀和
    * time: O(n)
    * space: O(min(n, k)), 最多有k个不同的余数
    * */
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            //map的key是前缀和mod k， value是前缀和mod k出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            //sum % k 为0 说明sum可以被k整除，直接计数为1
            map.put(0, 1);
            int res = 0;
            int sum = 0;
            for(int num : nums){
                //sum是前缀和
                sum += num;
                //为了处理负数，eg： k = 4, sum = -6, -6 % 4 = -2, -2 + 4 = 2, 2 % 4 = 2
                int modules = (sum % k + k) % k;
                int same = map.getOrDefault(modules, 0);
                res += same;
                map.put(modules, same + 1);
            }
            return res;
        }
    }
}
