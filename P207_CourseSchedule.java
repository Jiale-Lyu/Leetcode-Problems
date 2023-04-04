package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lv Jiale on 2/8/2023.
 */
public class P207_CourseSchedule {

    /*
    * 拓扑排序（入读表bfs)
    * time: O(N+M) N个节点，M条边
    * space: O(N+M)
    * */
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            //标记每个数的入度
            int[] inDegrees = new int[numCourses];
            //初始化邻接表的每个元素
            for(int i = 0; i < numCourses; i++){
                adjacency.add(new ArrayList<>());
            }
            //入度表中记录每个数的入度数
            //邻接表中每个数，和他的后续课列表
            for(int[] cp : prerequisites){
                inDegrees[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }
            //把所有入度为0的数入队
            for(int i = 0; i < numCourses; i++){
                if(inDegrees[i] == 0) queue.offer(i);
            }
            while(!queue.isEmpty()){
                int pre = queue.poll();
                numCourses--;
                for(int cur : adjacency.get(pre)){
                    if(--inDegrees[cur] == 0) queue.offer(cur);
                }
            }
            return numCourses == 0;
        }
    }


    /*
    * dfs
    * time: O(N+M) N个节点，M条边
    * space: O(N+M)
    * */
    class Solution2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            int[] inDegree = new int[numCourses];
            int[] flag = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                adjacency.add(new ArrayList<>());
            }
            for(int[] cp : prerequisites){
                inDegree[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }
            for(int i = 0; i < numCourses; i++){
                if(!dfs(adjacency, i, flag)) return false;
            }
            return true;
        }
        public boolean dfs(List<List<Integer>> adjacency, int i, int[] flag){
            //这个点在这条路上遍历过了，这条路上有环，所有课不能全上完
            if(flag[i] == 1) return false;
            //这个点在其他路上遍历过了，且没环，无需再重复
            if(flag[i] == -1) return true;
            //本条路访问过了，标记为1
            flag[i] = 1;
            //递归访问当前节点的所有邻接点
            for(Integer j : adjacency.get(i)){
                if(!dfs(adjacency, j, flag)) return false;
            }
            //这条路走到头了，没环
            flag[i] = -1;
            return true;
        }
    }
}
