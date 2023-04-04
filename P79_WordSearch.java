package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/21/2023.
 */
public class P79_WordSearch {



    /*
    * 回溯dfs
    * time: O(MN* 3^L) L 是string的长度
    * space: O(MN) visited, 同时栈的深度最大为O(min(L, MN))
    * */
    class Solution {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    //不要在这里判断第一个字母是否match，检查要放在dfs里面
                    boolean res = dfs(board, word, visited, m, n, i, j, 0);
                    if(res){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, String word, boolean[][] visited, int m, int n, int i, int j, int idx){
            if(board[i][j] != word.charAt(idx)){
                return false;
            }else if(idx == word.length() - 1){
                return true;
            }
            visited[i][j] = true;
            boolean res = false;
            for(int[] d : dirs){
                int x = i + d[0], y = j + d[1];
                // if(x >= 0 && y >= 0 && x < m && y < n){
                //     if(!visited[x][y]){
                //         res = dfs(board, word, visited, m, n, x, y, idx+1);
                //         if(res){
                //             res = true;
                //             break;
                //         }
                //     }
                // }
                if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y]){
                    continue;
                }
                //注意不要用++idx, 这一步走出去不可逆，如果走错了，idx已经加1了
                res = res = dfs(board, word, visited, m, n, x, y, idx + 1);
                if(res){
                    return true;
                }

            }
            visited[i][j] = false; //回溯，走出去，如果不对了再回来，状态重置
            return res;
        }
    }
}
