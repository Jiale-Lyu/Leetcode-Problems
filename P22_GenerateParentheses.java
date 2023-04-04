package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lv Jiale on 2/23/2023.
 */
public class P22_GenerateParentheses {


    /*
    * dfs
    * time: O(n)
    * space: O(logn)
    * */
    class Solution {
        //系统栈的深度优先遍历（回溯算法）
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if(n == 0){
                return res;
            }
            dfs("", 0, 0, n, res);
            return res;
        }
        public void dfs(String cur, int left, int right, int n, List<String> res){
            if(left == n && right == n){ //终止条件（叶子节点）：左右都达到n个括号了
                res.add(cur);
                return;
            }
            if(left < right){ //终止条件：无效str
                return;
            }
            if(left < n){ //左括号没达到n个
                dfs(cur + "(", left + 1, right, n, res);
            }
            if(right < n){ //右括号没达到n个
                dfs(cur + ")", left, right + 1, n, res);
            }
        }
    }

    /*
    * bfs
    * time: O(n)
    * space: O()
    * */
    class Solution2 {
        class Node{
            String str;
            int left;
            int right;
            public Node(String str, int left, int right){
                this.str = str;
                this.left = left;
                this.right = right;
            }
        }
        //bfs要自己定义Node
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node("", n, n));
            //从栈里取出节点，处理，再压入栈里，
            while(!queue.isEmpty()){
                Node cur = queue.poll();
                if(cur.left == 0 && cur.right == 0){
                    res.add(cur.str);
                }
                if(cur.left > 0){
                    queue.offer(new Node(cur.str + "(", cur.left - 1, cur.right));
                }
                if(cur.right > 0 && cur.right > cur.left){ //减枝：对比一下左右剩的数量，不符合不压栈
                    queue.offer(new Node(cur.str + ")", cur.left, cur.right - 1));
                }
            }
            return res;
        }
    }
}
