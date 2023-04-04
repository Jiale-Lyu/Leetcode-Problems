package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 1/24/2023.
 */


public class P39_CombinationSum {

    /*
    * time: tbd
    * space: tbd
    * */
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();
            int len = candidates.length;
            if(len == 0) return res;
            dfs(candidates, 0, len, target, res, path);
            return res;
        }
        private void dfs(int[] candidates, int begin, int len, int target, List<List<Integer>> res, Deque<Integer> path){
            //target为负数和0时，不再产生新的叶子节点
            if(target < 0) return;
            if(target == 0){
                res.add(new ArrayList<>(path));
                return;
            }
            //每个分支begin为搜索起点，当一个分支结束，下一个分支以begin+1为起点搜索，避免有重复的结果
            for(int i = begin; i < len; i++){
                path.push(candidates[i]);
                //因为每个数可以重复利用，所以下一轮起点依然是i
                dfs(candidates, i, len, target - candidates[i], res, path);
                //状态重置
                path.pop();
            }

        }
    }


    /*
    * 减枝提速
    *
    * */
    class Solution2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int len = candidates.length;
            if(len == 0) return res;
            Deque<Integer> path = new ArrayDeque<>();
            //排序是剪枝的前提
            Arrays.sort(candidates);
            dfs(candidates, len, 0, target, path, res);
            return res;
        }
        private void dfs(int[] candidates, int len, int depth, int target, Deque<Integer> path, List<List<Integer>> res){
            //递归终止条件只需判断等于0的情况，小于0都被剪掉了
            if(target == 0){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = depth; i < len; i++){
                //小于0剪枝，退出循环，后面的数不用再运算了，因为数组有序，后面的一定更小于0
                if(target - candidates[i] < 0){
                    break;
                }
                path.push(candidates[i]);
                dfs(candidates, len, i, target - candidates[i], path, res);
                //状态重置
                path.pop();
            }
        }
    }
}
