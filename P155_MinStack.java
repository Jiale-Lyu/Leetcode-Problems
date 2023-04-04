package com.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Lv Jiale on 1/4/2023.
 */
public class P155_MinStack {

    /*
    * 3种方法实现：
    * 1. 辅助栈minStack
    * 2. 定义Node，栈元素中同时存储最小值
    * 3. 以单链表的形式自定义一个栈
    * */

    /*
    * 1. 辅助栈minStack
    *
    * time: O(1)
    * space: O(n)
    * */
    class MinStack1 {

        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack1() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /*
    * 2. 定义Node，栈元素中同时存储最小值
    * time: O(1)
    * space: O(n)
    * */
    class MinStack2 {
        private Stack<Node> stack;

        public MinStack2() {
            stack = new Stack<Node>();
        }

        public void push(int val) {
            if(stack.isEmpty()){
                stack.push(new Node(val, val));
            }else{
                stack.push(new Node(val, Math.min(val, stack.peek().min)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }

        private class Node{
            int val;
            int min;
            public Node(int val, int min){
                this.val = val;
                this.min = min;
            }
        }
    }

    /*
    * 3. 以单链表的形式自定义一个栈
    * time: O(1)
    * space: O(n)
    * */
    class MinStack3 {

        private Node head;
        public MinStack3() {}

        public void push(int val) {
            if(head == null){
                head = new Node(val, val);
            }else{
                head = new Node(val, Math.min(val, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private class Node{
            int val;
            int min;
            Node next;
            public Node(int val, int min){
                this(val, min, null);
            }
            public Node(int val, int min, Node next){
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

    }

}
