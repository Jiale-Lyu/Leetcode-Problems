package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 1/23/2023.
 */
public class P47_Permutations_II {


    /*
    * time: O(N*N!)
    * space: O(N*N!)
    * */
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            Deque<Integer> path = new LinkedList<>();
            boolean[] used = new boolean[len];
            //排序是减枝的前提
            Arrays.sort(nums);
            dfs(nums, len, 0, path, res, used);
            return res;
        }
        private void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, boolean[] used){
            if(depth == len){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < len; i++){
                //这个数被选过了，就不能选了
                if(used[i]) continue;
                //i>0是为了nums[i-1]有意义,!used[i-1]表示i-1刚刚被撤销选择
                if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
                path.push(nums[i]);
                used[i] = true;
                dfs(nums, len, depth+1, path, res, used);
                path.pop();
                used[i] = false;
            }
        }
    }
}
