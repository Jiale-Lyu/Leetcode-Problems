package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lv Jiale on 1/12/2023.
 */
public class P696_CountBinarySubstrings {

    /*
    *
    * 先统计相同数字的个数，存到list中，再在list中相邻两个数中取较小值，加起来
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public int countBinarySubstrings(String s) {
            List<Integer> counts = new ArrayList<Integer>();
            int ptr = 0;
            while(ptr < s.length()){
                char c = s.charAt(ptr);
                int count = 0;
                while(ptr < s.length() && c == s.charAt(ptr)){
                    ptr++;
                    count++;
                }
                counts.add(count);
            }
            int res = 0;
            for(int i = 1; i < counts.size(); i++){
                res += Math.min(counts.get(i - 1), counts.get(i));
            }
            return res;
        }
    }

    /*
    * 不用arraylist存每个数的个数，用last存储前一个数，同时比较运算
    * time: O(n)
    * space: O(1)
    * */
    class Solution2 {
        public int countBinarySubstrings(String s) {
            int ptr = 0, ans = 0, last = 0;
            while(ptr < s.length()){
                int count = 0;
                char c = s.charAt(ptr);
                while(ptr < s.length() && c == s.charAt(ptr)){
                    ptr++;
                    count++;
                }
                ans += Math.min(count, last);
                last = count;
            }
            return ans;
        }
    }
}
