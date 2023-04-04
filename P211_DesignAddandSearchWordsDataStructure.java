package com.leetcode.solution;

/**
 * Created by Lv Jiale on 3/5/2023.
 */
public class P211_DesignAddandSearchWordsDataStructure {

    class WordDictionary {
        class TrieNode{
            private TrieNode[] next;
            private boolean isWord;
            //不用定义value，node[0] != null 就代表a
            public TrieNode(){
                isWord = false;
                next = new TrieNode[26];
            }
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.next[c - 'a'] == null){
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            return dfs(word, root, 0);
        }

        public boolean dfs(String word, TrieNode node, int start){
            if(start == word.length()){
                return node.isWord;
            }
            char c = word.charAt(start);
            if(c == '.'){ //递归查询26个next，只要有1个能返回true就是true，说明能match上
                for(int i = 0; i < 26; i++){
                    if(node.next[i] != null && dfs(word, node.next[i], start+1)){
                        return true;
                    }
                }
                return false; //26个next都没返回true，返回false
            }else{
                if(node.next[c - 'a'] == null){
                    return false;
                }
                return dfs(word, node.next[c - 'a'], start + 1);
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
