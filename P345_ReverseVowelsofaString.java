package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/8/2023.
 */
public class P345_ReverseVowelsofaString {

    /*
    * 判断元音方法
    * t: O(n)
    * s: O(n)
    * */
    class Solution {
        public String reverseVowels(String s) {
            int a = 0, b = s.length() - 1;
            char[] res = s.toCharArray();
            while(a < b){
                if(!isVowel(res[a])){
                    a++;
                }
                if(!isVowel(res[b])){
                    b--;
                }
                if(isVowel(res[a]) && isVowel(res[b])){
                    char tmp = res[a];
                    res[a] = res[b];
                    res[b] = tmp;
                    a++;
                    b--;
                }
            }
            //把char[]变成string
            return new String(res);
            // return String.valueOf(res);
        }
        public boolean isVowel(char x){
            //如果x不在string中，返回值为-1
            return "aeiouAEIOU".indexOf(x) >=0;
        }
    }
}

