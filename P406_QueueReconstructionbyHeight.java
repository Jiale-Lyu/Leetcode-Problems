package com.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lv Jiale on 3/31/2023.
 */
public class P406_QueueReconstructionbyHeight {


    /*
    *
    * time: O(n^2) 其中 n 是数组 people的长度。我们需要O(nlogn) 的时间进行排序，随后需要 O(n^2)的时间遍历每一个人并将他们放入队列中。
    * 由于前者在渐近意义下小于后者，因此总时间复杂度为 O(n^2)
    *
    * space: O(logn)
    * */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            //按照身高降序，个数升序排序，后放矮的不会影响已经放好的高个的k值
            Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            List<int[]> list = new ArrayList<>();
            for(int[] p : people){ //O(n^2) 因为add数组不是顺序加的，而是从前往后查找index放的
                list.add(p[1], p); //以个数为index加入list中
            }
            return list.toArray(new int[0][]);
        }
    }

}
