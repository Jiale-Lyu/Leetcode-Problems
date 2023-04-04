package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/30/2023.
 */
public class P667_BeautifulArrangement_II {


    /*
    * 找规律
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            int min = 1, max = n;
            for(int i = 0; i < k; i++){ //前k个数，偶数位从小到大，奇数位从大到小
                res[i] = i % 2 == 0 ? min++ : max--;
            }
            for(int i = k; i < n; i++){ //后k个数，k是奇数，递增；k是偶数，递减
                res[i] = k % 2 == 0 ? res[i - 1] - 1 : res[i - 1] + 1;
            }
            return res;
        }
    }
}
