package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lv Jiale on 1/23/2023.
 */
public class P46_Permutations {


    /*
    * time: O(N * N!), 最后一层共N！个节点，在叶子节点处拷贝需要O（N）
    * space: O(N * N!)，地归树深度logN, 全排列个数N！，每个全排列占的空间N，取较大者
    * */
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            boolean[] used = new boolean[len];
            Deque<Integer> path = new LinkedList<>();
            dfs(nums, len, 0, used, path, res);
            return res;
        }
        public void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res){
            //终止条件，path的深度和数组长度一样，说明到底了，加到结果里
            if(len == depth){
                //new一个copy加进去，直接加是引用
                res.add(new ArrayList<>(path));
                return;
            }
            //循环数组的每个值
            for(int i = 0; i < len; i++){
                //如果这个数用过，跳过这个数
                if(used[i]) continue;
                //没用过，就加到path里
                path.push(nums[i]);
                used[i] = true;
                //对这个数进行dfs递归
                dfs(nums, len, depth + 1, used, path, res);
                //处理完再弹出这个数，回到之前的状态，回溯
                path.pop();
                used[i] = false;
            }
        }
    }
}
