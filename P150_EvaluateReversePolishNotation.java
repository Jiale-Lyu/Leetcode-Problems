package com.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Lv Jiale on 2/23/2023.
 */
public class P150_EvaluateReversePolishNotation {


    /*
    * 栈
    * time: O(n)
    * space: O(n)
    * */
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for(int i = 0; i < tokens.length; i++){
                String str = tokens[i];
                if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")){
                    stack.push(Integer.valueOf(str)); //String转int： Integer.valueOf(), Integer.parseInt()
                }else{
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    if(str.equals("+")){ //注意str的比较用equals，==比较的是地址
                        stack.push(num1 + num2);
                    }else if(str.equals("-")){
                        stack.push(num1 - num2);
                    }else if(str.equals("*")){
                        stack.push(num1 * num2);
                    }else{
                        stack.push(num1 / num2);
                    }
                }
            }
            return stack.pop();
        }
    }
}
