package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/2/2023.
 */
public class P461_HammingDistance {

    /*
    * 内置 位计数函数
    * time: O(1)
    * space: O(1)
    * */
    class Solution {
        public int hammingDistance(int x, int y) {
            //a = x ^ y，a中的1的个数，就是x，y不同的位数
            //Integer.bitCount()计算数字二进制中1的个数的函数
            return Integer.bitCount(x ^ y);
        }
    }

    /*
    * 移位实现位计数
    * */
    class Solution2 {
        public int hammingDistance(int x, int y) {
            int s = x ^ y;
            int ans = 0;
            while(s != 0){
                //当s最后一位是1时，ans+1；是0时，ans+0
                ans += s & 1;
                //s右移一位
                s >>= 1;
            }
            return ans;
        }
    }

    /*
    * 算法
    * */
    class Solution3 {
        public int hammingDistance(int x, int y) {
            int s = x ^ y;
            int ans = 0;
            while(s != 0){
                //s & (s - 1) 是s删去其二进制最右侧的1的结果
                s &= s - 1;
                ans++;
            }
            return ans;
        }
    }
}
