package com.trello;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Trello trelloApp = new Trello();

        // User 1 posts a tweet
        trelloApp.postTweet(1, 101);

        // User 2 follows User 1
        trelloApp.follow(2, 1);

        // User 2 posts a tweet
        trelloApp.postTweet(2, 102);

        // User 2's news feed should show tweet 102 and 101
        List<Integer> newsFeed = trelloApp.getNewsFeed(2);
        System.out.println("User 2's news feed: " + newsFeed);

        // User 2 unfollows User 1
        trelloApp.unfollow(2, 1);

        // Now User 2's feed should only show their own tweet
        newsFeed = trelloApp.getNewsFeed(2);
        System.out.println("User 2's news feed after unfollowing User 1: " + newsFeed);
    }
}
