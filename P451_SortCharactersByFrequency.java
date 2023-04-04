package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Lv Jiale on 2/15/2023.
 */
public class P451_SortCharactersByFrequency {


    /*
    * 优先队列
    * time: O(max(n, ClogC)) C个节点要添加到优先队列中
    * space: O(n)
    * */
    class Solution {
        public String frequencySort(String s) {
            //map记录频次
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            //放入优先队列
            //java匿名表达式，频数不同按降序排，相同按字母升序排
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
                return a[1] != b[1] ? b[1] - a[1] : a[0] - b[0];
            });
            for(char c : map.keySet()){
                q.add(new int[]{c, map.get(c)}); //c记录的是ascii码
            }
            //放入数组
            StringBuilder str = new StringBuilder();
            while(!q.isEmpty()){
                int[] pair = q.poll();
                int c = pair[0], k = pair[1];
                while(k-- > 0){
                    str.append((char)c);
                }
            }
            return str.toString();
        }
    }
}
