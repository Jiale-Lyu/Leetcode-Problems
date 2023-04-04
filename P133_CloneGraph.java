package com.leetcode.solution;

import java.util.*;
import java.util.List;

/**
 * Created by Lv Jiale on 3/8/2023.
 */
public class P133_CloneGraph {


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    /*
    * dfs
    * time: O(n)
    * space: O(n) hashmap
    * */
    class Solution {
        Map<Node, Node> visited = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node == null){
                return node;
            }
            if(visited.containsKey(node)){
                return visited.get(node);
            }
            Node clone = new Node(node.val, new ArrayList<>()); //不能clone node的neighbors
            visited.put(node, clone);
            for(Node neighbor: node.neighbors){
                clone.neighbors.add(cloneGraph(neighbor));
            }
            return clone;
        }
    }



    // bfs
    // time: O(n)
    // space: O(n)
    class Solution2 {
        public Node cloneGraph(Node node) {
            if(node == null){
                return null;
            }
            Map<Node, Node> visited = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            visited.put(node, new Node(node.val, new ArrayList<>()));
            queue.offer(node);
            while(!queue.isEmpty()){ //一次循环处理一个node
                Node cur = queue.poll();
                for(Node neighbor: cur.neighbors){ //处理这个node的邻居们
                    if(!visited.containsKey(neighbor)){
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        queue.offer(neighbor);
                    }
                    visited.get(cur).neighbors.add(visited.get(neighbor));//连上新建的节点的邻居们
                }

            }
            return visited.get(node);
        }
    }
}