package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/8/2023.
 */
public class P190_ReverseBits {

    /*
    * time: O(1)
    * space: O(1)
    * */
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for(int i = 0; i < 32; i++){
                res = res << 1 | n & 1; //给res后面加0或1
                n >>>= 1; //java没有无符号整数类型，因此对 n 的右移操作应使用逻辑右移
            }
            return res;
        }
    }
}
