package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/22/2023.
 */
public class P125_ValidPalindrome {

    /*
    * equals方法比较的是两个对象是否相等，如果不进行重写，默认比较地址。
    当使用同一个字符串建立两个StringBuilder对象时，用equals比较得到的结果是false，因为Stringbuild没有对equals方法进行重写。
    但当转为String后再比较时得到的结果是true，因为String类中对equals方法进行了重写，比较的是两个对象的值，而非地址，所以结果为true。

    * */
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sgood = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(Character.isLetterOrDigit(s.charAt(i))){
                    sgood.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            //new StringBuilder(sgood)再reverse，reverse是stringbuilder的函数
            StringBuilder sgood_rev = new StringBuilder(sgood).reverse();
            return sgood.toString().equals(sgood_rev.toString());
            //StringBuilder.equals()比较的是地址，toString()之后的equals()比较的是值
        }
    }
}
