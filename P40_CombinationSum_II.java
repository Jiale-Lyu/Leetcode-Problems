package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 1/24/2023.
 */
public class P40_CombinationSum_II {


    /*
    * dfs+剪枝去重(大，小)
    * 第 39 题：candidates 中的数字可以无限制重复被选取；
    * 第 40 题：candidates 中的每个数字在每个组合中只能使用一次。
    * */
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int len = candidates.length;
            Deque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[len];
            if(len == 0) return res;
            //剪枝的前提是排序
            Arrays.sort(candidates);
            dfs(candidates, len, 0, target, res, path);
            return res;
        }
        private void dfs(int[] candidates, int len, int begin, int target, List<List<Integer>> res, Deque<Integer> path){
            if(target == 0){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = begin; i < len; i++){
                //大剪枝，target减去candidate[i]小于0，减去后面的一定更小于0，跳过后面所有数，所以break
                if(target - candidates[i] < 0){
                    break;
                }
                //小剪枝，同一层的元素，从第二个开始，和前面重复了就跳过这个数，用continue
                if(i > begin && candidates[i] == candidates[i-1]){
                    continue;
                }
                path.push(candidates[i]);
                //因为元素不能重复使用，所以i+1
                dfs(candidates, len, i+1, target - candidates[i], res, path);
                path.pop();
            }
        }
    }
}
