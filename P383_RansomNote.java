package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/29/2023.
 */
public class P383_RansomNote {

    /*
    * time: O(m+n)
    * space: O(26)
    * */
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if(magazine.length() < ransomNote.length()){
                return false;
            }
            //创建一个26个长度的数组
            int[] cnt = new int[26];
            //遍历magazine数组，以其中每个字符对应的数字为下标，统计这个字符出现的个数
            for(char c : magazine.toCharArray()){
                cnt[c - 'a']++;
            }
            //遍历ransomNote数组，--，一旦出现小于0的数，说明ransomNote中有，mangazine中没有
            for(char c : ransomNote.toCharArray()){
                cnt[c - 'a']--;
                if(cnt[c - 'a'] < 0){
                    return false;
                }
            }
            return true;
        }
    }
}
