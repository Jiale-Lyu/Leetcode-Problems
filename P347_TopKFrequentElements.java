package com.leetcode.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Lv Jiale on 2/15/2023.
 */
public class P347_TopKFrequentElements {


    /*
    * time:O(nlogk) n是数组长度，遍历统计频率n, 维护k个元素的堆logk
    * space: O(n)
    * */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            //先得到每个数字的频数存到map中
            for(int n : nums){
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            //优先队列默认是小顶堆
            //改写Comparator，让小顶堆queue按元素的频数来排序（queue中放的是数字不是频数）
            PriorityQueue<Integer> queue = new PriorityQueue<>(
                    new Comparator<Integer>(){
                        public int compare(Integer a, Integer b){
                            return map.get(a) - map.get(b);
                        }
                    }
            );
            //遍历出现过的数，频数是否比
            for(int key : map.keySet()){
                if(queue.size() < k){
                    queue.add(key);
                }else if(map.get(queue.peek()) < map.get(key)){
                    queue.remove();
                    queue.add(key);
                }
            }
            //把优先队列的数移到array中
            int[] res = new int[k];
            int i = 0;
            while(!queue.isEmpty()){
                res[i++] = queue.remove();
            }
            return res;
        }
    }
}
