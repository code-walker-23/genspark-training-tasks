# Trello — Simplified Social Media Simulator in Java

![Project FLow](https://github.com/code-walker-23/genspark-training-tasks/blob/main/milestone1/project-flow.png)

A lightweight Java-based simulation of a social media platform where users can:

- Post messages ("Trello tweets")
- Follow or unfollow other users
- View their personalized news feed with the 10 most recent tweets from themselves and followed users

---

## 📌 Functional Requirements

1. **Post Tweet**
   - A user can post a tweet using their `userId` and a unique `tweetId`.

2. **Get News Feed**
   - Returns the 10 most recent tweet IDs from the user and people they follow, sorted from most recent to oldest.

3. **Follow User**
   - A user can follow another user using their `userId`.

4. **Unfollow User**
   - A user can unfollow another user.

---

## ⚙️ Non-Functional Requirements

- Designed using **LLD principles** (Low-Level Design)
- Only basic collections used (`List`), no `Map`, `HashSet`, or external libraries
- Fully **object-oriented design**:
  - Each class has a single responsibility
  - Clean interface and encapsulation
- IDE-independent — can be run with any Java compiler

---

## 🧱 Class Design

| Class    | Responsibility |
|----------|----------------|
| `Main`   | Entry point of the application. Demonstrates the features. |
| `Trello` | Core logic: posting tweets, following/unfollowing users, and generating news feeds. |
| `User`   | Represents a user, stores their tweets and the users they follow. |
| `Tweet`  | Represents a tweet with an ID and timestamp. |

---

## 🔁 Flow of Execution (Detailed)

1. **`Main` instantiates the `Trello` app.**
   - This creates the main application object that manages users and their interactions.

2. **Users can perform the following actions:**

   ### ✅ `postTweet(userId, tweetId)`
   - **Purpose**: Allows a user to create a new tweet.
   - **Behavior**:
     - If the user does not exist yet, they are automatically created.
     - A new `Tweet` object is instantiated with a unique timestamp.
     - The tweet is added to the user’s personal tweet list.

   ### ✅ `follow(followerId, followeeId)`
   - **Purpose**: Allows one user to follow another user.
   - **Behavior**:
     - If the follower or followee does not exist, they are created.
     - The `followeeId` is added to the list of users the `followerId` follows.

   ### ✅ `unfollow(followerId, followeeId)`
   - **Purpose**: Allows a user to unfollow another user.
   - **Behavior**:
     - If the `followerId` exists and follows the `followeeId`, the `followeeId` is removed from their follow list.
     - Users cannot unfollow themselves (optional safeguard).

   ### ✅ `getNewsFeed(userId)`
   - **Purpose**:  To retrieve the most recent tweets visible to a user, including their own tweets and those of the users they follow.
   - **Behavior**:  
     - If the user doesn't exist, an empty news feed is returned.
     - Tweets are gathered from:
       - The user themselves (`userId`)
       - All users they follow
     - All collected tweets are combined and **sorted in descending order of timestamp** (most recent first).
     - Only the **10 most recent tweet IDs** are returned as the user's personalized news feed.

---

## 🧪 Sample Usage

```java
Trello app = new Trello();
app.postTweet(1, 101);        // User 1 posts tweet 101
app.follow(2, 1);             // User 2 follows User 1
app.postTweet(2, 102);        // User 2 posts tweet 102

List<Integer> feed = app.getNewsFeed(2);  // Expected: [102, 101]
System.out.println("User 2's news feed: " + feed);

app.unfollow(2, 1);           // User 2 unfollows User 1
feed = app.getNewsFeed(2);    // Expected: [102]
System.out.println("User 2's news feed after unfollow: " + feed);
<<<<<<< HEAD

```

=======
>>>>>>> d28b2f21135a2957958cc8c97e68b40dad940dad
