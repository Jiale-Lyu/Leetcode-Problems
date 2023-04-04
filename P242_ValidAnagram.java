package com.leetcode.solution;

import java.util.*;


public class P242_ValidAnagram {
    //思路：
    //1. char可转变为Array然后sort
    //2. HashMap 记录每个字符出现的次数



    //to char array and sort
    //Time complexity:O(NlogN)
    //Space complexity:O(logN), 排序的空间复杂度是O(logN)
//    public static boolean isAnagram(String s, String t) {
//        char[] s1 = s.toCharArray();
//        char[] t1 = t.toCharArray();
//        Arrays.sort(s1);
//        Arrays.sort(t1);
//        return Arrays.equals(s1, t1);
//    }

    //HashMap
    //Time Complexity: O(N), N is the length of string s
    //Space Complexity: O(N), N is the length of this char set, which is 26
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int j = 0; j < t.length(); j++){
            char ch = t.charAt(j);
            map.put(ch, map.getOrDefault(ch,0) - 1);
            if(map.get(ch) < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s1 = "anagram";
        String s2 = "nagarma";
        System.out.println(isAnagram(s1, s2));
    }
}
