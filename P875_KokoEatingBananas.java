package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/27/2023.
 */
public class P875_KokoEatingBananas {

    /*
    * right/left = mid, while循环条件必须是l < r,不能加=
    * time: O()
    * space: O()
    * */
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int maxVal = 1;
            for(int pile : piles){
                maxVal = Math.max(pile, maxVal);
            }
            int left = 1, right = maxVal;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(calculateH(piles, mid) > h){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            return left;
        }
        public int calculateH(int[] piles, int speed){
            int sum = 0;
            for(int pile : piles){
                sum += (pile + speed - 1) / speed;
            }
            return sum;
        }
    }
}
