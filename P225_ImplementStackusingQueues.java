package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 1/4/2023.
 */
public class P225_ImplementStackusingQueues {


    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */


    /*
    * poll()和offer()是一对，源自于Queue
    *
    * 疑问：（queue, linkedlist）, （dequeue, arraydequeue）是搭配使用的吗，哪个是实现stack，哪个实现queue？
    * time: push:O(n), others:O(1)
    * space: O(n)
    * */
    class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue2.offer(x);
            while(!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = new LinkedList<Integer>();
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

}
