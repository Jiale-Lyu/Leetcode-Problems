package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/7/2023.
 */
public class P338_CountingBits {

    /*
    *
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int[] countBits(int n) {
            int[] res = new int[n + 1];
            res[0] = 0;
            for(int i = 1; i < n + 1; i++){
                if(i % 2 == 1){
                    res[i] = res[i - 1] + 1; //i是奇数，i中1的个数是前面那个偶数+1
                }else{
                    res[i] = res[i / 2];  //i是偶数，i中1的个数是i/2中的1的个数
                }
            }
            return res;
        }
    }
}
