package com.leetcode.solution;

/**
 * Created by Lv Jiale on 1/27/2023.
 */
public class P278_FirstBadVersion {

/* The isBadVersion API is defined in the parent class VersionControl.*/
    class VersionControl{
        boolean isBadVersion(int version){
            return true;
        };
    }

    /*
    * 二分法
    * logn
    * 1
    * */
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 0, r = n;
            //循环到左右相等
            while(l < r){
                int mid = l + (r - l) / 2;
                if(isBadVersion(mid)){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return l;
        }
    }

}
