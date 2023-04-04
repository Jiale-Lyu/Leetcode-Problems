package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/21/2023.
 */
public class P67_AddBinary {

    /*
    * 二进制加法，考察stringbuilder的用法
    * time: O(max(a, b))
    * space: O(1)
    * */
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();
            int car = 0; //carry
            //a,b从后往前遍历
            for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
                int sum = car;
                sum += i >= 0 ? a.charAt(i) - '0' : 0;
                sum += j >= 0 ? b.charAt(j) - '0' : 0;
                ans.append(sum % 2); //和的当前位
                car = sum / 2; //和的进位
            }
            ans.append(car == 1 ? car : ""); //如果有进位就加1
            return ans.reverse().toString();
        }
    }
}
