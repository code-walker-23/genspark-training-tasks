package com.trello;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int userId;
    private final List<Tweet> tweets;
    private final List<Integer> following;

    public User(int userId) {
        this.userId = userId;
        this.tweets = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void postTweet(int tweetId, int timestamp) {
        tweets.add(new Tweet(tweetId, timestamp));
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void follow(int followeeId) {
        if (followeeId != this.userId && !following.contains(followeeId)) {
            following.add(followeeId);
        }
    }

    public void unfollow(int followeeId) {
        following.remove(Integer.valueOf(followeeId));
    }

    public List<Integer> getFollowing() {
        return following;
    }
}
