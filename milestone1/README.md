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

## 🔁 Flow of Execution

1. `Main` instantiates the `Trello` app.
2. Users can:
   - Post tweets via `postTweet(userId, tweetId)`
   - Follow other users via `follow(followerId, followeeId)`
   - Unfollow using `unfollow(followerId, followeeId)`
3. When `getNewsFeed(userId)` is called:
   - Tweets from the user and followed users are collected
   - They are sorted by timestamp (most recent first)
   - The top 10 tweet IDs are returned

---

