package com.leetcode.solution;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Created by Lv Jiale on 1/4/2023.
 */
public class P232_ImplementQueueusingStacks {
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    /*
    * 3个小错误：
    * 1. Deque<Integer> inStack;
    * 2. new ArrayDeque<Integer>();
    * 3. in2out()；
    *
    * time: push/isEmpty: O(1), peek/pop: 均摊O(1)。对于每个元素，至多入栈和出栈各两次，故均摊复杂度为 O(1)。
    * space: O(n)
    * */
    class MyQueue {

        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<Integer>();
            outStack = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if(outStack.isEmpty()){
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if(outStack.isEmpty()){
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
        public void in2out(){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }

    }


}
