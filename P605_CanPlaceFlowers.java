package com.leetcode.solution;

/**
 * Created by Lv Jiale on 4/3/2023.
 */
public class P605_CanPlaceFlowers {


    /*
    * 贪心
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int i = 0, len = flowerbed.length;
            while(i < len && n > 0){
                if(flowerbed[i] == 1){ //遇到1，下一个位置肯定不行，跳过
                    i += 2;
                }else if(i == len - 1 || flowerbed[i+1] == 0){ //0前面一个肯定是0，因为遇到1会跳两下 && 没有相邻的花，所以只判断后面是否为0，最后一个数例外
                    n--;
                    i += 2;
                }else{ //如果当前数是0 && 后一个数是1，跳三下
                    i += 3;
                }
            }
            return n <= 0;
        }
    }
}
