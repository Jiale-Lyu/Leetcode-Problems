package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/5/2023.
 */
public class P621_TaskScheduler {


    /*
    * 桶思想
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] tmp = new int[26];
            int maxTimes = 0; //出现次数最多的任务出现的次数
            int maxCount = 0; //有几个任务出现次数最多
            for(char c : tasks){ //找出最多的次数
                tmp[c - 'A']++;
                maxTimes = Math.max(tmp[c - 'A'], maxTimes);
            }
            for(int i = 0; i < 26; i++){ //出现最多次数的任务个数
                if(tmp[i] == maxTimes){
                    maxCount++;
                }
            }
            int res = (maxTimes - 1) * (n + 1) + maxCount;
            return Math.max(res, tasks.length); //如果桶有空闲res大，如果没空闲，tasks.length大
        }
    }

}
