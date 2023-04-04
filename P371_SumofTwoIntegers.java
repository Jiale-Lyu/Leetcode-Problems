package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/4/2023.
 */
public class P371_SumofTwoIntegers {

    /*
    * 异或：无进位相加
    * 与 + <<1 ： 获取进位
    * */
    class Solution {
        public int getSum(int a, int b) {
            //当还有进位时，继续循环
            while(b != 0){
                //& 和 移位 获取进位
                int carry = (a & b) << 1;
                //无进位加法
                a = a ^ b;
                // b记录进位
                b = carry;
            }
            return a;
        }
    }
}
