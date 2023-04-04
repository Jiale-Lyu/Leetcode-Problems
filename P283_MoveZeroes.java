package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/12/2023.
 */
public class P283_MoveZeroes {

    /*
    * 两次循环
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for(int i = 0; i < nums.length; i++){ //第一次循环j统计数组中非0的数，只要是非0的统统赋值给nums[j]
                if(nums[i] != 0){
                    nums[j++] = nums[i];
                }
            }
            for(int i = j; i < nums.length; i++){ //第二次循环，从j（最后一个非0数的下一位）开始后面都赋0
                nums[i] = 0;
            }
        }
    }


    /*
    * 一次循环
    * 参考快排思想，把非0的放在左边，0放在右边
    * time: O(n)
    * space: O(1)
    * */

    class Solution2 {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){ //遍历每个数，如果非0， 就放在nums[j]中
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = tmp;
                }
            }
        }
    }

}
