package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/7/2023.
 */
public class P191_Numberof1Bits {

    /*
    * 算术右移 >> ：舍弃最低位，高位用符号位填补；
      逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
    *
    * time: O(k) k为二进制的长度
    * space: O(1)
    * */
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for(int i = 0; i < 32; i++){
                count += n & 1; //0 & 任何数都是0； 1 & 任何数是任何数
                n >>= 1; //向右移位
            }
            return count;
        }
    }
}
