package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 3/15/2023.
 */
public class P290_WordPattern {

    /*
    * int Integer装箱拆箱
    * time: O(n)
    * space: O(m+n)
    * */
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] word = s.split(" ");
            if(pattern.length() != word.length){
                return false;
            }
            Map<Object, Integer> map = new HashMap<>(); //用Object是因为不能让下面的两种key一样
            //如果用int，map.put的时候会自动装箱i转为Integer，超过-127~128的部分会存在内存中而不是缓存，会装到不同的箱子里，用==比较的是地址
            //如果用Integer，初始化i的时候已经自动装箱过了，装到一个箱子里
            for(Integer i = 0; i < pattern.length(); i++){
                //如果map中没有key，put（key， value）进去，返回null；如果放过，返回key之前的value
                if(map.put(pattern.charAt(i), i) != map.put(word[i], i)){ //利用返回值来判断双向对应关系
                    return false;
                }
            }
            return true;
        }
    }

}
