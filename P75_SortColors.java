package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/11/2023.
 */
public class P75_SortColors {

    /*
    * 国旗问题
    * time: O(n)
    * space: O(1)
    * */
    class Solution {
        public void sortColors(int[] nums) {
            int len = nums.length;
            if(len < 2){
                return;
            }
            //0: [0,zero)
            //1: [zero,i)
            //2: [two,len-1]
            //因为0不包含zero，所以zero初始值可以是下标0
            //因为2要包含two，所以two初始值得是最后一个元素的后一个下标
            int zero = 0, i = 0, two = len;
            while(i < two){
                //因为0不包含zero，zero不是0，所以先交换，zero再加一，保证zero前面的都是0
                if(nums[i] == 0){
                    swap(nums, i, zero);
                    zero++;
                    i++;
                    //把i看成one
                }else if(nums[i] == 1){
                    i++;
                    //因为2包含two，所以下标为two的数本身就是2，就要先减1再交换
                }else{
                    two--;
                    swap(nums, i, two);
                }
            }
        }
        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }


}
