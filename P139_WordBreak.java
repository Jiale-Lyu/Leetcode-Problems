package com.leetcode.solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lv Jiale on 3/16/2023.
 */
public class P139_WordBreak {

    /*
    * dp
    * time: O(n^2)
    * space: O(n)
    * */
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1]; //dp表示第i个数之前都可以break
            dp[0] = true;
            for(int i = 1; i <= s.length(); i++){
                for(int j = 0; j < i; j++){ //从0到i之间
                    if(dp[j] && set.contains(s.substring(j, i))){ //只要有一个地方j是true并且后面剩的在单词表里
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    //dfs记忆化递归
    /*
    * time: O(n^2)
    * space: O(n)
    * */
    class Solution2 {
        Boolean[] memo;
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            memo = new Boolean[len + 1];
            return dfs(s, len, new HashSet<>(wordDict));
        }
        public boolean dfs(String s, int n, Set<String> set){
            if(n == 0){
                return true;
            }
            if(memo[n] != null){ //赋过值就直接用
                return memo[n];
            }
            memo[n] = false;
            for(int i = 0; i < n; i++){
                boolean right = set.contains(s.substring(i, n)); //如果右半部分是个单词
                if(!right){
                    continue;
                }
                boolean left = dfs(s, i, set); //如果左半部分子问题也同时成立
                if(left){
                    memo[n] = true;
                    break;
                }
            }
            return memo[n];
        }
    }
}
