package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/12/2023.
 */
public class P647_PalindromicSubstrings {

    /*
    * 中心拓展法
    * time: (n)
    * space: (1)
    * */
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length();
            int num = 0;
            for(int i = 0; i < n; i++){ //遍历回文中心
                for(int j = 0; j <= 1; j++){ //j=0中心是一个点，j=1中心是两个点
                    int l = i;
                    int r = i + j;
                    while(l >= 0 && r < n && s.charAt(l--) == s.charAt(r++)) num++;
                }
            }
            return num;
        }
    }


    /*
    * 动态规划法。。。
    * */
}
