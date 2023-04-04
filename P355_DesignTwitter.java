package com.leetcode.solution;

import java.util.*;

/**
 * Created by Lv Jiale on 3/5/2023.
 */
public class P355_DesignTwitter {

    /*
    * Design题
    * */
    class Twitter {
        class Tweet{
            int id;
            int timeStamp;
            Tweet next; //发的tweets用链表存
            public Tweet(int id, int timeStamp){
                this.id = id;
                this.timeStamp = timeStamp;
            }
        }

        Map<Integer, Set<Integer>> followings; //userId--followings
        Map<Integer, Tweet> twitter; //userId--tweet
        PriorityQueue<Tweet> maxHeap;
        int timeStamp = 0;

        public Twitter() {
            followings = new HashMap<>();
            twitter = new HashMap<>();
            maxHeap = new PriorityQueue<>((a, b) -> b.timeStamp - a.timeStamp); //最大堆
        }

        public void postTweet(int userId, int tweetId) {
            timeStamp++;
            if(twitter.containsKey(userId)){
                Tweet oldHead = twitter.get(userId);
                Tweet newHead = new Tweet(tweetId, timeStamp);
                newHead.next = oldHead;
                twitter.put(userId, newHead);
            }else{
                twitter.put(userId, new Tweet(tweetId, timeStamp));
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            maxHeap.clear(); //由于全局使用，使用之前需要清空
            if(twitter.containsKey(userId)){
                maxHeap.offer(twitter.get(userId)); //先把自己的tweet头放入优先队列
            }
            Set<Integer> followingList = followings.get(userId);
            if(followingList != null && followingList.size() > 0){ //把自己follow的所有人的最近一次tweet放入优先队列(head)
                for(Integer followingId: followingList){
                    Tweet tweet = twitter.get(followingId);
                    if(tweet != null){
                        maxHeap.offer(tweet);
                    }
                }
            }
            List<Integer> res = new ArrayList<>(10);
            int count = 0;
            while(!maxHeap.isEmpty() && count < 10){ //合并n个排序链表
                Tweet head = maxHeap.poll();
                res.add(head.id);
                if(head.next != null){
                    maxHeap.add(head.next);
                }
                count++;
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            if(followerId == followeeId){ //如果关注的是自己，什么都不用做
                return;
            }
            Set<Integer> followingList = followings.get(followerId);
            if(followingList == null){
                Set<Integer> init = new HashSet<>();
                init.add(followeeId);
                followings.put(followerId, init);
            }else{
                followingList.add(followeeId);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            if(followeeId == followerId){
                return;
            }
            Set<Integer> followingList = followings.get(followerId);
            if(followingList == null){
                return;
            }
            followingList.remove(followeeId); //不用判断
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
