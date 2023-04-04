package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/10/2023.
 */
public class P9_PalindromeNumber {

    /*
    * 反转数的后一半
    * time: O(log n)
    * space: O(1)
    * */
    class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0 || (x % 10 == 0 && x != 0)) return false; //负数或者个位是0的数

            int revertedNum = 0;
            while(revertedNum < x){
                revertedNum = revertedNum * 10 + x % 10;
                x /= 10;
            }
            return revertedNum == x || revertedNum/10 == x;
        }
    }
}
