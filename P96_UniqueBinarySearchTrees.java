package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/16/2023.
 */
public class P96_UniqueBinarySearchTrees {

    /*
    * dfs
    * 由大问题向下划分，大问题由小问题组成
    * time: O(n)
    * space: O(n)
    * */
     class Solution {
        Integer[] memo;
        public  int  numTrees(int n) {
            memo = new Integer[n + 1];
            return dfs(n);
        }

        public  int dfs(int n) {
            if (n <= 1) {
                return 1;
            }
            if (memo[n] != null) { //memoization
                return memo[n];
            }
            int res = 0;
            for (int i = 1; i <= n; i++) {
                int L = dfs(i - 1);
                int R = dfs(n - i);
                res += L * R; //以n=3为例，memo[n]+= 左边孩子们能形成的bst个数 * 右边孩子们能形成bst的个数
            }
            memo[n] = res;
            return res;
        }
    }

 }
//
// /*
// * 把dfs反过来从小往大计算，最终回到顶层问题
// * time: (n^2)
// * space: O()
// * */
//    class Solution2 {
//        public int numTrees(int n) {
//            int[] dp = new int[n + 1];
//            dp[0] = dp[1] = 1;
//            for(int i = 2; i <= n; i++){
//                for(int j = 1; j <= i; j++){ //j范围是[1,3]，以n=3为例，dp[3]可以分为以1，2，3为root的bst个数相加
//                    dp[i] += dp[j - 1] * dp[i - j];
//                }
//            }
//            return dp[n];
//        }
//    }
//}
//
////             3
////    /        |        \
////   1         2          3
////[],[2,3]  [1],[3]     [1,2],[]
////1*2    +    1*1    +    2*1
