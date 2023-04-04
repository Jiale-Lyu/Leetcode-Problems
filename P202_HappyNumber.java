package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/6/2023.
 */
public class P202_HappyNumber {

    /*
    * time: O(logn)
    * space: O(1)
    * */
    class Solution {
        public int getNext(int n){
            int sum = 0;
            while(n != 0){
                int x = n % 10;
                n = n / 10;
                sum += x * x;
            }
            return sum;
        }
        //肯定会形成循环，用快慢指针来找出循环，判断循环是否由1造成，是就是快乐数，否则不是
        public boolean isHappy(int n) {
            int fast = n, slow = n;
            do{
                fast = getNext(fast);
                fast = getNext(fast);
                slow = getNext(slow);
            }while(fast != slow);
            return fast == 1;
        }
    }
}
