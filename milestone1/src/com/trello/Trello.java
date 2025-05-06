package com.trello;

import java.util.ArrayList;
import java.util.List;
public class Trello {
    private final List<User> users;
    private int timestamp;

    public Trello() {
        this.users = new ArrayList<>();
        this.timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        User user = getOrCreateUser(userId);
        user.postTweet(tweetId, timestamp++);
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        if (user == null) return new ArrayList<>();

        // Include own tweets
        List<Tweet> allTweets = new ArrayList<>(user.getTweets());

        // Include followed users' tweets
        for (int followeeId : user.getFollowing()) {
            User followee = getUser(followeeId);
            if (followee != null) {
                allTweets.addAll(followee.getTweets());
            }
        }

        // Sort by timestamp descending
        allTweets.sort((a, b) -> b.getTimestamp() - a.getTimestamp());

        // Get up to 10 most recent tweets
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            result.add(allTweets.get(i).getTweetId());
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        User follower = getOrCreateUser(followerId);
        getOrCreateUser(followeeId); // ensure followee exists
        follower.follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        if (follower != null) {
            follower.unfollow(followeeId);
        }
    }

    private User getUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) return user;
        }
        return null;
    }

    private User getOrCreateUser(int userId) {
        User user = getUser(userId);
        if (user == null) {
            user = new User(userId);
            users.add(user);
        }
        return user;
    }
}