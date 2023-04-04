package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/8/2023.
 */
public class P633_SumofSquareNumbers {

    /*
    * 左右双指针
    * t: O(√c)
    * s: O(1)
    * */
    class Solution {
        public boolean judgeSquareSum(int c) {
            //left取0，因为0也算是非负整数
            //遇到平方，为防止溢出用long定义
            //a和b肯定小于√c
            long left = 0, right = (long)Math.sqrt(c);
            //a和b可以相等
            while(left <= right){
                long sum = left * left + right * right;
                if(sum == c){
                    return true;
                }else if(sum < c){
                    left++;
                }else{
                    right--;
                }
            }
            return false;
        }
    }

}
