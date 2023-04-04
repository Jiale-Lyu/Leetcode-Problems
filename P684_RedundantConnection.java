package com.leetcode.solution;

/**
 * Created by Lv Jiale on 2/2/2023.
 */
public class P684_RedundantConnection {


    /*
    * 并查集
    * time: O(nlogn)
    * space: O(n) n个节点roots[]
    * */
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            //数的顶点数比边数多1
            int n = edges.length + 1;
            UnionFind uf = new UnionFind(n);
            for(int i = 0; i < n; i++){
                int[] edge = edges[i];
                //如果边的两个顶点在一个集合中，说明这条边就是导致成环的边
                if(uf.isConnected(edge[0], edge[1])){
                    return edge;
                }
                //否则连接两点
                uf.union(edge[0], edge[1]);
            }
            //返回空数组
            return new int[0];
        }

        class UnionFind{
            int[] roots;
            public UnionFind(int n){
                roots = new int[n];
                for(int i = 0; i < n; i++){
                    roots[i] = i;
                }
            }
            public int find(int i){
                if(roots[i] == i){
                    return i;
                }
                return roots[i] = find(roots[i]);
            }
            public boolean isConnected(int p, int q){
                return find(p) == find(q);
            }
            public void union(int p, int q){
                roots[find(p)] = find(q);
            }
        }
    }
}
