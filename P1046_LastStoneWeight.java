package com.leetcode.solution;

import java.util.PriorityQueue;

/**
 * Created by Lv Jiale on 3/5/2023.
 */
public class P1046_LastStoneWeight {

    /*
    * 最大堆
    * time: O(nlogn)每次从堆里取元素需要logn时间
    * space: O(n)
    * */
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //最大堆
            for(int stone : stones){
                pq.offer(stone);
            }
            while(pq.size() > 1){
                int x = pq.poll();
                int y = pq.poll();
                if(x > y){ //x先poll，所以x >= y
                    pq.offer(x - y);
                }
            }
            return pq.isEmpty() ? 0: pq.poll();
        }
    }
}
