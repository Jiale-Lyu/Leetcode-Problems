package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lv Jiale on 3/1/2023.
 */
public class P138_CopyListwithRandomPointer {


// Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    /*
    * 用hashmap存node的对应关系
    * time: O(n)
    * space: O(n)
    *
    * */
    class Solution {
        public Node copyRandomList(Node head) {
            if(head == null){
                return null;
            }
            Map<Node, Node> map = new HashMap<>();
            Node p = head;
            while(p != null){ //第一次遍历，创建新node并放入map中
                Node newNode = new Node(p.val);
                map.put(p, newNode);
                p = p.next;
            }
            p = head;
            while(p != null){ //第二次遍历，设定next和random指向
                Node newNode = map.get(p);
                newNode.next = map.get(p.next);
                newNode.random = map.get(p.random);
                p = p.next;
            }
            return map.get(head);

        }
    }
}
