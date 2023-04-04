package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lv Jiale on 4/4/2023.
 */
public class P763_PartitionLabels {


    /*
    *
    * time: O(n)
    * space: O(26)
    * */
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
            for(int i = 0; i < s.length(); i++){
                last[s.charAt(i) - 'a'] = i; //用array存每个字母最后一次出现的下标
            }
            int start = 0, end = 0;
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < s.length(); i++){
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if(end == i){ //重要步骤，此时当前partition走完了
                    res.add(end - start + 1);
                    start = end + 1;
                }
            }
            return res;
        }
    }
//my solution: hashmap存每个字母最后一次出现的下标
// class Solution {
//     public List<Integer> partitionLabels(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         for(int i = 0; i < s.length(); i++){
//             map.put(s.charAt(i), i);
//         }
//         List<Integer> list = new ArrayList<>();
//         for(int i = 0; i < s.length(); i++){
//             int start = i;
//             int end = map.get(s.charAt(i));
//             while(i < end){
//                 end = Math.max(end, map.get(s.charAt(i)));
//                 i++;
//             }
//             list.add(end - start + 1);
//         }
//         return list;
//     }
// }
}
