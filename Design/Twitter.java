package Design;

import java.util.*;

public class Twitter {

    Map<Integer, Set<Integer>> userIdToFollowMap;
    LinkedHashMap<Integer, Integer> tweetToUserIDMap;
    /** Initialize your data structure here. */
    public Twitter() {
        userIdToFollowMap = new HashMap<>();
        tweetToUserIDMap = new LinkedHashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweetToUserIDMap.put(tweetId, userId);

    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followingSet = userIdToFollowMap.getOrDefault(followerId, new HashSet<>());
        followingSet.add(followeeId);
        userIdToFollowMap.put(followerId, followingSet);
    }

    public void unfollow(int followerId, int followeeId) {

        if (userIdToFollowMap.containsKey(followerId)){
            Set<Integer> followingSet = userIdToFollowMap.get(followerId);
            if(followingSet.contains(followeeId))
                followingSet.remove(followeeId);
            userIdToFollowMap.put(followerId, followingSet);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetsToPostList = new ArrayList<>();

        for (int tweetId : tweetToUserIDMap.keySet()){
            if (tweetsToPostList.size() == 10)
                return tweetsToPostList;
            int followerId = tweetToUserIDMap.get(tweetId);

                if (followerId == userId || userIdToFollowMap.get(userId).contains(followerId))
                    tweetsToPostList.add(tweetId);
        }
        Collections.reverse(tweetsToPostList);
        return tweetsToPostList;
    }
    public static void main(String[] args){
        Twitter t = new Twitter();
        t.postTweet(1,4);
        t.postTweet(2,5);
        System.out.print(t.getNewsFeed(1));
//        t.follow(1,2);
//        t.postTweet(2,6);
//        System.out.print(t.getNewsFeed(1));
//        t.unfollow(1,2);
//        System.out.print( t.getNewsFeed(1));
    }
}
