package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/31/2023.
 */
public class P769_MaxChunksToMakeSorted {


    /*
    * 注意range [0, n - 1]
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int len = arr.length, ans = 0;
            int min = len, max = -1;
            for(int i = 0, j = 0; i < len; i++){ //j不动，i往后走，区间[j, i]，当j==min, i == max时，形成  一组
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                if(min == j && max == i){
                    ans++;
                    j = i + 1;
                    min = len;
                    max = -1;
                }
            }
            return ans;
        }
    }
}
