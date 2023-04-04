package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Lv Jiale on 1/25/2023.
 */
public class P77_Combinations {

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> stack = new ArrayDeque<>();
            if(k <= 0 || n < k) return res;
            dfs(n, k, 1, stack, res);
            return res;
        }
        private void dfs(int n, int k, int begin, Deque<Integer> stack, List<List<Integer>> res){
            //判断要放在for循环外面，
            if(stack.size() == k){
                res.add(new ArrayList<>(stack));
                return;
            }
            //for(int i = begin; i <= n; i++){
            //begin是循环的起点，每循环一次，i往后移动1位
            //循环终点，根据stack有几个数，还需要几个数来剪枝
            for(int i = begin; i <= (n - (k - stack.size()) + 1); i++){
                stack.push(i);
                //搜索起点+1，因为组合里不能有重复数
                dfs(n, k, i+1, stack, res);
                //恢复没选这个数时的状态
                stack.pop();
            }
        }
    }


}
