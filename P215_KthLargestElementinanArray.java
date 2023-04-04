package com.leetcode.solution;

import java.util.PriorityQueue;

/**
 * Created by Lv Jiale on 1/13/2023.
 */
public class P215_KthLargestElementinanArray {


    /*
    * minHeap
    * 维护一个k个元素的小根堆, online algorithm, scalable if input is a stream
    * time: O(nlogk) or O(n^2logk) ???
    * space: O(n)
    * */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for(int x : nums){
                if(heap.size() < k || x >= heap.peek()){ //如果堆中元素小于k个 || 大于堆顶应元素，放入堆中
                    heap.offer(x);
                }
                if(heap.size() > k){ //如果堆中元素大于k个，弹出堆顶的最小元素
                    heap.poll();
                }
            }
            return heap.peek();
        }
    }

    //更简单写法
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int n : nums){
                queue.offer(n); //不管大小先offer，超过大小就poll
                if(queue.size() > k){
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }
}
