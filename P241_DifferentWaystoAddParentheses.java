package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lv Jiale on 2/7/2023.
 */
public class P241_DifferentWaystoAddParentheses {


    /*
    * divide and conquer
    * 递归
    * */
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> list = new ArrayList<>();
            int len = expression.length();
            int start = 0;
            //如果全是数字没有符号，就把数字加入list并返回（不会进入for循环）
            for(start = 0; start < len; start++){
                if(Character.isDigit(expression.charAt(start))) continue;
                else break;
            }
            if(start == len) list.add(Integer.parseInt(expression));
            //for循环每遍历到符号就停一下，递归左右两侧的表达式，并计算结果加入list
            //是数字就跳过
            for(int i = start; i < len; i++){
                if(Character.isDigit(expression.charAt(i))) continue;
                char op = expression.charAt(i);
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1,len));
                for(int l : left){
                    for(int r : right){
                        if(op == '+') list.add(l+r);
                        else if(op == '-') list.add(l-r);
                        else if(op == '*') list.add(l*r);
                    }
                }
            }
            return list;
        }
    }



}
