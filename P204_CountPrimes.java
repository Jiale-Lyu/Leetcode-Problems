package com.leetcode.solution;

import java.util.Arrays;

/**
 * Created by Lv Jiale on 2/22/2023.
 */
public class P204_CountPrimes {

    /*
    * 素数
    * time: O(nloglogn)
    * space: O(n)
    * */
    class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            //Wrong: isPrime.fill(true);
            Arrays.fill(isPrime, true);
            // 从 2 开始枚举到 sqrt(n)
            for(int i = 2; i * i < n; i++){
                //如果当前是素数
                if(isPrime[i]){
                    //就把从i^2开始，i的倍数都设成false
                    for(int j = i * i; j < n; j += i){
                        isPrime[j] = false;
                    }
                }
            }
            //计数
            int cnt = 0;
            for(int i = 2; i < n; i++){
                if(isPrime[i]){
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
