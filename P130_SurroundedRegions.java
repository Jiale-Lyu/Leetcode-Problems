package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/8/2023.
 */
public class P130_SurroundedRegions {

    /*
    * time: O(mn) mn是矩阵的行列数
    * space: O(mn) 栈开销
    * */
    class Solution {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public void solve(char[][] board) {
            int m = board.length, n = board[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    boolean isBorder = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                    if(isBorder && board[i][j] == 'O'){
                        dfs(board, i, j, m, n);
                    }
                }
            }
            for(int i = 0; i < m; i++){ //遇到#还改回O，其余的O就是中间的被X包围的，改成X
                for(int j = 0; j < n; j++){
                    if(board[i][j] == '#'){
                        board[i][j] = 'O';
                    }else if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
        }

        //逆向思维，把所有和边界上的O相连的O都变成#
        public void dfs(char[][] board, int i, int j, int m, int n){
            if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || board[i][j] == '#'){
                return;
            }
            board[i][j] = '#';
            for(int[] d : dir){
                dfs(board, i + d[0], j + d[1], m, n);
            }
        }
    }
}
