package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 1/8/2023.
 */
public class P205_IsomorphicStrings {


    /*
    * 用两个hashmap存映射关系
    * time: O(n)
    * space: O(S), 哈希表存储字符的空间取决于字符串的字符集大小.
    *
    * */
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> s2t = new HashMap<>();
            Map<Character, Character> t2s = new HashMap<>();

            int len = s.length();

            for(int i = 0; i < len; i++){
                char x = s.charAt(i);
                char y = t.charAt(i);
                if((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)){
                    return false;
                }
                s2t.put(x, y);
                t2s.put(y, x);
            }
            return true;

        }
    }
}
