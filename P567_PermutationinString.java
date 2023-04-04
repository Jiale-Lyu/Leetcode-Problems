package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 2/23/2023.
 */
public class P567_PermutationinString {

    /*
    * 滑动窗口
    * time: O(n + m + 26)
    * space: O(26)
    * */
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];

            if(n > m){
                return false;
            }

            for(int i = 0; i < n; i++){
                cnt1[s1.charAt(i) - 'a']++; //记录s1中的所有的字符频数
                cnt2[s2.charAt(i) - 'a']++; //记录s2中前n个字符频数
            }

            if(Arrays.equals(cnt1, cnt2)){
                return true;
            }

            //滑动窗口长度为n, 往后一位一位的平移窗口，进窗口的字母频数+1，出窗口的字母频数-1
            for(int i = n; i < m; i++){
                cnt2[s2.charAt(i) - 'a']++;
                cnt2[s2.charAt(i - n) - 'a']--;
                if(Arrays.equals(cnt1, cnt2)){
                    return true;
                }
            }
            return false;
        }
    }
}
