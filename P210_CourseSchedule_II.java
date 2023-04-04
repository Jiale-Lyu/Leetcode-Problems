package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lv Jiale on 2/8/2023.
 */
public class P210_CourseSchedule_II {


    /*
    * bfs
    * */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            int[] inDegree = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            int[] res = new int[numCourses];
            int count = 0;
            for(int i = 0; i < numCourses; i++){
                adjacency.add(new ArrayList<>());
            }
            for(int[] cp : prerequisites){
                inDegree[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }
            for(int i = 0; i < numCourses; i++){
                if(inDegree[i] == 0) queue.offer(i);
            }
            while(!queue.isEmpty()){
                int cur = queue.poll();
                res[count]=cur;
                count++;
                for(int j : adjacency.get(cur)){
                    if(--inDegree[j] == 0) queue.offer(j);
                }
            }
            if(count != numCourses) return new int[0];
            return res;
        }
    }
}
