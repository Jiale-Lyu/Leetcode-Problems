package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/23/2023.
 */
public class P5_LongestPalindromicSubstring {


    /*
    * dp
    * time: O(n^2) n是字符串的长度
    * space: O(n^2)
    * */
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if(n < 2){
                return s;
            }
            boolean[][] dp = new boolean[n][n];
            char[] num = s.toCharArray();
            int maxlen = 1, begin = 0;
            //i 和 j 变换位置， 因为只需要填右上三角形的值
            for(int j = 0; j < n; j++){
                for(int i = 0; i <= j; i++){
                    if(num[i] == num[j]){
                        if(j - i < 3){ //如果去掉头尾，剩1个或0个字符，就是true，(j-1) - (i+1) + 1 < 2
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j] && j - i + 1 > maxlen){ //不用存最长的字串，只用存下标和长度
                        maxlen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxlen);
        }
    }
}
