package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/23/2023.
 */
public class P424_LongestRepeatingCharacterReplacement {


    /*
    * 滑动窗口
    * time: O(n)
    * space: O(A) 输入s中出现的字符范围
    * */
    class Solution {
        public int characterReplacement(String s, int k) {
            int l = 0, r = 0;
            char[] chars = s.toCharArray();
            int[] appear = new int[26]; //记录每个字母出现的频数
            int historyMax = 0; //历史上窗口内出现过最多次数的字母频数 而不是 窗口内出现最多次数的字母频数
            for(r = 0; r < s.length(); r++){
                int idx = s.charAt(r) - 'A';
                appear[idx]++; //r的频数加一
                historyMax = Math.max(historyMax, appear[idx]);
                //如果窗口比historyMax + k还大，左边界向右移，l的频数减小
                if(r - l + 1 > historyMax + k){
                    appear[s.charAt(l) - 'A']--;
                    l++;
                }
            }
            return r - l;  //r会走到s.length处，也就是最后一个数的下一个位置，所以不用+1
        }
    }
}
