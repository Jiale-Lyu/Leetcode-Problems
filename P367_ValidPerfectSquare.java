package com.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lv Jiale on 2/14/2023.
 */

/*
* //对 num 进行不断的奇数试减，如果最终能够减到 0, 说明num是完全平方数
* */
public class P367_ValidPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int x = 1;
            while(num > 0){
                num -= x;
                x += 2;
            }
            return num == 0;
        }
    }
}
