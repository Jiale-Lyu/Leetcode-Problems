package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 3/3/2023.
 */
public class P853_CarFleet {


    /*
    * 理解题意很重要，不能超车，追上之后降速
    * time：O(nlogn)
    * space: O(logn)?
    * */
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            float[] time = new float[n];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                map.put(position[i], speed[i]); //记录每辆车的位置和速度
            }
            Arrays.sort(position); //按离终点距离从远到近排序
            Deque<Float> stack = new LinkedList<>();
            for(int i = n - 1; i >= 0; i--){
                time[i] = (float)(target - position[i]) / map.get(position[i]);
                if(!stack.isEmpty() && time[i] <= stack.peek()){ //前面的时间<=后面的时间,说明前面的能追上后面的，不入栈
                    continue;
                }else{
                    stack.push(time[i]);
                }
            }
            return stack.size();
        }
    }
}
