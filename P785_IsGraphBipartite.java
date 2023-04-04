package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lv Jiale on 2/1/2023.
 */
public class P785_IsGraphBipartite {


    /*
    * bfs
    * time: O(N + M) 其中 N 是无向图的顶点数，M 是无向图的边数。
    * space: O(N)
    * */
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int[] visited = new int[graph.length];
            Queue<Integer> queue = new LinkedList<>();
            //graph.length就是图中的节点个数
            for(int i = 0; i < graph.length; i++){
                //着过色的节点跳过
                if(visited[i] != 0){
                    continue;
                }
                queue.offer(i);
                visited[i] = 1;
                while(!queue.isEmpty()){
                    int v = queue.poll();
                    //遍历这个节点的邻居
                    for(int w : graph[v]){
                        //如果邻居也着过色，并且和自己颜色相同，返回false
                        if(visited[w] == visited[v]){
                            return false;
                        }
                        //如果邻居没着色，着相反的颜色，加入队列
                        //注意这里不能用！，因为visited不是boolean
                        if(visited[w] == 0){
                            visited[w] = -visited[v];
                            queue.offer(w);
                        }
                    }
                }
            }
            return true;
        }
    }


    /*
    * 并查集
    * time: O(N + M) 其中 N 是无向图的顶点数，M 是无向图的边数。
    * space: O(N)
    * */
    class Solution2 {
        public boolean isBipartite(int[][] graph) {
            UnionFind uf = new UnionFind(graph.length);
            //遍历图中每个顶点
            for(int i = 0; i < graph.length; i++){
                //adjs是这个顶点的邻居们
                int[] adjs = graph[i];
                for(int w : adjs){
                    //判断这个顶点和这个邻居是否相连
                    if(uf.isConnected(w, i)){
                        return false;
                    }
                    //把所有的邻居相连
                    uf.union(w, adjs[0]);
                }
            }
            return true;
        }

        //并查集
        class UnionFind{
            int[] roots;
            public UnionFind(int n){
                roots = new int[n];
                for(int i = 0; i < n; i++){
                    roots[i] = i;
                }
            }
            //寻根
            public int find(int i){
                if(roots[i] == i){
                    return i;
                }
                //注意这里不仅返回，还要赋值
                return roots[i] = find(roots[i]);
            }
            //判断p，q是否在同一集合中
            public boolean isConnected(int p, int q){
                return find(p) == find(q);
            }
            //合并p，q到同一集合中
            public void union(int p, int q){
                roots[find(p)] = find(q);
            }
        }
    }
}
