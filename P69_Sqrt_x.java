package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/25/2023.
 */
public class P69_Sqrt_x {


    /*
    * 如果面试遇到这道题，应该首先回答二分法，这是程序员的思路，然后回答牛顿法，能推导一下公式当然是最好的啦。个人建议，仅供参考。
    * */

    /*
    * 二分法
    * time: O(log x)
    * space: O(1)
    * */
    class Solution {
        public int mySqrt(int x) {
            int l = 0, r = x;
            if(x == 0) return 0;
            //模板：1. while 永远是 l <= r
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(mid * mid == x){
                    return mid;
                }else if((long)mid * mid < x){
                    l = mid + 1; //2. 永远
                }else{
                    r = mid - 1; //3. 永远
                }
            }
            //如果答案落在left = middle + 1 的里面， 最终return right
            //如果答案落在right=middle + 1 里面， 最终return left
            return l - 1;
        }
    }
    /*
    * 牛顿法
    * time: O(log x), 此方法是二次收敛的，比二分查找更快
    * space: O(1)
    * 导数是函数在某一点切线的斜率
    * */
    class Solution2 {
        public int mySqrt(int x) {
            if(x == 0) return 0;
            double C = x, x0 = x;
            //进行k次迭代后，xk的值与真实的零点根号C足够接近，即可作为答案
            while(true){
                double xi = 0.5 * (x0 + C / x0);
                if(Math.abs(x0 - xi) < 1e-7){ //差值小于1的-7次方（科学记数法e表示指数）
                    break;
                }
                x0 = xi; //不断更新x0的值，无限接近于0点
            }
            return (int)x0;
        }
    }

    /*
    * 袖珍计算器法
    * time: O(1)
    * space: O(1)
    * */
    class Solution3 {
        public int mySqrt(int x) {
            if(x == 0) return 0;
            //用指数函数和对数函数代替平方根函数
            int ans = (int)Math.exp(0.5 * Math.log(x));
            return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
        }
    }
}
