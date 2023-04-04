package com.leetcode.solution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Lv Jiale on 3/5/2023.
 */
public class P703_KthLargestElementinaStream {
    class KthLargest {
        /*
        * 优先队列
        * 最小堆
        * time: 初始化O(nlogk)，插入O(logk) n为nums长度
        * space: O(k)
        * */
        Queue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            this.k = k;
            for(int n : nums){
                add(n);
            }
        }

        //控制小根堆中有不超过k个元素
        public int add(int val) {
            pq.offer(val);
            if(pq.size() > k){ //不用比较新元素和pq顶的元素大小，先加进去!!如果栈大小超过k，再弹出队列最小元素
                pq.poll();
            }
            return pq.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
