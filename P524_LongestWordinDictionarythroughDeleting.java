package com.leetcode.solution;

import java.util.List;

/**
 * Created by Lv Jiale on 2/10/2023.
 */
public class P524_LongestWordinDictionarythroughDeleting {

    /*
    * 双指针
    * time: O(d*(m+n)) d是dictionary的长度，m是s的长度，n是dictionary中string的平均长度
    * space: O(1)
    * */
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String res = "";
            for(String d : dictionary){
                int i = 0, j = 0;
                while(i < s.length() && j < d.length()){
                    if(s.charAt(i) == d.charAt(j)){
                        j++;
                    }
                    i++;
                }
                if(j == d.length()){
                    //String.compareTo()按字典顺序比较两个字符串
                    if(d.length() > res.length() || (d.length()== res.length() && d.compareTo(res) < 0)){
                        res = d;
                    }
                }

            }
            return res;
        }
    }
}
