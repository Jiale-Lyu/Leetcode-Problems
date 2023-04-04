package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/7/2023.
 */
public class P260_SingleNumber_III {


    /*
    * 异或用法
    * n
    * 1
    * */
    class Solution {
        public int[] singleNumber(int[] nums) {
            //0异或任何数值不变
            int xor = 0;
            //xor存的是两个单独数的异或
            for(int n : nums){
                xor ^= n;
            }
            //-xor是xor的补码，一个数&自己的补码能得到最低为为1的数
            //这一位为1说明两个数在这一位上是不同的
            int mask = xor & (-xor);
            int[] ans = new int[2];
            for(int n : nums){
                //按照&mask把数组分成两组，每组中只有1个数出现了1次，其余数都出现2次
                if((n & mask) == 0){
                    ans[0] ^= n;
                }else{
                    ans[1] ^= n;
                }
            }
            return ans;
        }
    }
}
