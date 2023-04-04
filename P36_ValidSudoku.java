package com.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lv Jiale on 2/22/2023.
 */
public class P36_ValidSudoku {




    /*
    * HashMap + HashSet
    * */
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Set<Integer>> row = new HashMap<>();
            Map<Integer, Set<Integer>> col = new HashMap<>();
            Map<Integer, Set<Integer>> box = new HashMap<>();

            //每行每列每个块都建个hashset
            for(int i = 0; i < 9; i++){
                row.put(i, new HashSet<>());
                col.put(i, new HashSet<>());
                box.put(i, new HashSet<>());
            }

            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    char c = board[i][j];
                    if(c == '.'){
                        continue;
                    }
                    int num = c - '0';
                    int idx = i / 3 * 3 + j / 3; //方块的编号
                    //行，列，块，任何一个set已经包含这个数，返回false
                    if(row.get(i).contains(num) || col.get(j).contains(num) || box.get(idx).contains(num)){
                        return false;
                    }
                    row.get(i).add(num);
                    col.get(j).add(num);
                    box.get(idx).add(num);
                }
            }
            return true;
        }
    }
}
