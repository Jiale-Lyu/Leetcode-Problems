package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/6/2023.
 */
public class P66_PlusOne {

    /*
    * 只需判断是否是9，是9置0
    * time: O(n) n是数组长度
    * space: O(1)
    * */
    class Solution {
        public int[] plusOne(int[] digits) {
            for(int i = digits.length - 1; i >= 0; i--){ //从后往前
                if(digits[i] == 9){
                    digits[i] = 0;
                }else{
                    digits[i]++;
                    return digits;
                }
            }
            digits = new int[digits.length + 1]; //如果所有位都进位
            digits[0] = 1;
            return digits;
        }
    }
}
