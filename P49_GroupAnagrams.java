package com.leetcode.solution;

import java.util.*;

public class P49_GroupAnagrams {


// 1、数组的hashcode是根据地址引用计算的。
// 2、Arrays.hashcode静态方法能够根据数组的内容创建相应的hashcode。
// 3、hashmap用数组做key时用的是地址引用计算的的hashcode，所以应避免使用数组为键。如果一定要用数组来作为map的key值的话，有两种方法：
// a.将数组转化为string b.用list代替

    /*
    * time: O(nklogk) n是strs字符串的数量，k是字符串最大长度，sort需要klogk, 遍历要n
    * space: O(nk) hashmap的空间
    * */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for(String str : strs){
                char[] array = str.toCharArray();
                Arrays.sort(array); //anagrams排好序后是一样的
                String key = new String(array);  //避免用数组做hashmap的key，数组的hashcode是根据地址计算的，转化为string或list
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list); //取出list，加str，再放进去
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
