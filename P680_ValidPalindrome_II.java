package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/8/2023.
 */
public class P680_ValidPalindrome_II {

    /*
    * 一个复杂的问题拆解成两个简单的小问题
    * t: O(n)
    * s: O(1)
    * */
    class Solution {
        public boolean validPalindrome(String s) {
            int a = 0, b = s.length() - 1;
            while(a < b){
                //从不一样的字符开始，后面的判断就交给下面的方法了
                if(s.charAt(a) != s.charAt(b)){
                    return validPalindrome(s, a + 1, b) ||
                            validPalindrome(s, a, b - 1);
                }
                a++;
                b--;
            }
            //本身就是回文
            return true;
        }
        public boolean validPalindrome(String s, int a, int b){
            while(a < b){
                if(s.charAt(a) != s.charAt(b)){
                    return false;
                }
                a++;
                b--;
            }
            return true;
        }
    }

}
