package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 2/16/2023.
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {

    //滑动窗口，用left记录窗口的左边界
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //hash的key是字符，value是字符的下标
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            int left = 0;
            for(int i = 0; i < s.length(); i++){
                if(map.containsKey(s.charAt(i))){ //如果这个字符在前面出现过，left跳到max(这个字符上次出现的位置+1，left)
                    left = Math.max(left, map.get(s.charAt(i)) + 1); //注意这里要取大的
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }
    }
}
