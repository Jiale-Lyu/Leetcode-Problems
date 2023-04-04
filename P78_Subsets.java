package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Lv Jiale on 1/25/2023.
 */
public class P78_Subsets {

    /*
    * 回溯法：选择是否存入当前索引的值，可以存，也可以不存；存->继续深度遍历；不存->继续深度遍历
    */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> t = new ArrayDeque<>();
            dfs(nums, 0, t, res);
            return res;
        }
        private void dfs(int[] nums, int cur, Deque<Integer> t, List<List<Integer>> res){
            //从前往后遍历，当cur遍历到最后一个数时，把栈里的数加入结果列表里
            if(cur == nums.length){
                res.add(new ArrayList<>(t));
                return;
            }
            //选择这个数，压入栈，对后一个数递归
            t.push(nums[cur]);
            dfs(nums, cur + 1, t, res);
            //从栈中弹出，恢复选择之前的状态；如果不选这个数，对后一个数递归
            t.pop();
            dfs(nums, cur + 1, t, res);
        }
    }

    /*
    * 同上，改成用ArrayList
    * */
    class Solution2 {
        //回溯法：选择是否存入当前索引的值，可以存，也可以不存；存->继续深度遍历；不存->继续深度遍历
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(nums, res, new ArrayList<Integer>(), 0);
            return res;
        }
        public void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int index){
            if(index == nums.length){
                res.add(new ArrayList<>(cur));
                return;
            }
            cur.add(nums[index]);
            dfs(nums, res, cur, index+1);
            cur.remove(cur.size() - 1);
            dfs(nums, res, cur, index+1);
        }
    }

    /*
    * 动态规划
    * */
}
