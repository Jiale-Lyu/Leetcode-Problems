package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/10/2023.
 */
public class P168_ExcelSheetColumnTitle {

    /*
    *
    * time: O(log26n)
    * space: O(1)
    *
    * */
    class Solution {
        public String convertToTitle(int columnNumber) {
            //StringBuilder是可变的String，主要有append和insert方法
            StringBuilder sb = new StringBuilder();
            while(columnNumber > 0){
                //A--1，所以要-1
                columnNumber--;
                sb.append((char)(columnNumber % 26 + 'A'));
                columnNumber /= 26;
            }
            sb.reverse();
            //StringBuilder.toString()转成String
            return sb.toString();
        }
    }
}
