package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 1/8/2023.
 */
public class P409_LongestPalindrome {


    /*
    * time: O(N)
    * space: O(N)
    * */
    class MySolution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                //map.merge(ch, 1, (a, b)-> a + b); 同样的效果，merge有三个参数，如果map中不存在ch，则把ch存入，value为1；如果map中存在ch，则value+1
            }
            int ans = 0;
            int odd = 0;
            for(char key : map.keySet()){
                if(map.get(key) % 2 == 0){
                    ans = ans + map.get(key);
                }else{
                    ans = ans + map.get(key) - 1;
                    odd = 1;
                }
            }
            return ans + odd;
        }
    }

    /*
    * ascii码一共有128个
    * 创建一个int数组来存每个字母asciii码对应出现的次数
    * time: O(n)
    * space: O(s) s为字符集的大小
    * */
    class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                count[c]++;
            }
            int ans = 0;
            for(int v : count){
                ans += v / 2 * 2;   //只取偶数
                if(v % 2 == 1 && ans % 2 == 0){ //保证只执行一次
                    ans++;
                }
            }
            return ans;
        }
    }

}
