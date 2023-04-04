package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 3/5/2023.
 */
public class P677_MapSumPairs {


    /*
    * time: O(N) N为key的长度
    * space: O(MN) M为键值对数目，N为key的最大长度
    * */
    class MapSum {
        class TrieNode{
            int val = 0;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root;
        Map<String, Integer> map; //用hashmap保证key一样的时候新的值覆盖前面的值

        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0); //因为之前的数已经被加到每个node中了，记录这次和上次的差值，更新每个node的val
            map.put(key, val);
            TrieNode node = root;
            for(char c: key.toCharArray()){
                if(node.next[c - 'a'] == null){
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
                node.val += delta; //每个node的值会被更新为-用的最新key的值
            }
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for(char c : prefix.toCharArray()){
                if(node.next[c - 'a'] == null){
                    return 0;
                }
                node = node.next[c - 'a'];
            }
            return node.val;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
