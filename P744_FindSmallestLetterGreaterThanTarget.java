package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/26/2023.
 */
public class P744_FindSmallestLetterGreaterThanTarget {

    /*
    * 二分法
    * */
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int l = 0, r = letters.length - 1;
            //注意边界情况
            if(target >= letters[r]){
                return letters[0];
            }
            //如果l或r有一个是mid, while的判断条件就不能有等于，否则会进入死循环
            while(l < r){
                int mid = l + (r - l) / 2;
                if(letters[mid] <= target){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            return letters[l];
        }
    }

    /*
    * 线性查找
    * time: O(n)
    * space O(1)
    * */
    class Solution2 {
        public char nextGreatestLetter(char[] letters, char target) {
            char nextGreater = letters[0];
            for(int i = 0; i < letters.length; i++){
                if(letters[i] > target){
                    nextGreater = letters[i];
                    break;
                }
            }
            return nextGreater;
        }
    }
}
