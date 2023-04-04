package com.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Lv Jiale on 1/4/2023.
 */
public class P739_DailyTemperatures {

    /*
    * 暴力解法，超时了
    * 对于每一个元素，循环找后面第一个更大的元素，下标相减存入数组。
    * */
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;
            int[] ans = new int[length];
            for(int i = 0; i < length; i++){
                if(temperatures[i] < 100){
                    for(int j = i + 1; j < length; j++){
                        if(temperatures[i] < temperatures[j]){
                            ans[i] = j - i;
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }
    /*
    * 单调栈，栈里的元素始终是递减的
    * https://leetcode.cn/problems/daily-temperatures/solutions/71433/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
    *
    * */
    class Solution2 {
        public int[] dailyTemperatures(int[] T) {
            int length = T.length;
            int[] ans = new int[length];
            Deque<Integer> stack = new LinkedList<Integer>();
            for(int i = 0; i < length; i++){
                while(!stack.isEmpty() && T[i] > T[stack.peek()]){ //栈不空 && 新元素大于栈顶元素
                    int pre = stack.pop(); //弹出栈顶元素
                    ans[pre] = i - pre; //存入下标差值
                }
                stack.push(i); //栈空 || 新元素比栈里的元素都小，压栈
            }
            return ans;
        }
    }
}
