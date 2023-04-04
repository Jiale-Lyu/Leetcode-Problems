package com.leetcode.solution;

import java.util.Stack;

public class P20_ValidParentheses {
    //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //
    //An input string is valid if:
    //1. Open brackets must be closed by the same type of brackets.
    //2. Open brackets must be closed in the correct order.

    //stack
    //来一个左括号，压入栈一个对应的右括号，来一个右括号，从栈中取出最上面的右括号来比较
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.isEmpty() || c != stack.pop()) return false;
            //如果此时是empty，说明前面的括号已经闭合，后面又来了一个右括号，所以是invalid的
        }
        return stack.isEmpty(); //左右括号都匹配完了，并且栈里空了，说明是valid的
    }
}
