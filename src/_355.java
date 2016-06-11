import java.util.*;

/**
 * LeetCode 355 - Design Twitter
 *
 * A pretty good design problem.
 */
public class _355 {

    Map<Integer, Set<Integer>> follower = new HashMap<>();
    Map<Integer, List<Integer>> tweets = new HashMap<>();
    Map<Integer, Integer> order = new HashMap<>();
    int timeStamp;

    /**
     * Initialize your data structure here.
     */
    public _355() {
        timeStamp = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, id -> new ArrayList<>()).add(tweetId);
        order.put(tweetId, timeStamp++);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((u, v) -> -Integer.compare(
                order.get(tweets.get(u[0]).get(u[1])),
                order.get(tweets.get(v[0]).get(v[1]))));
        if (tweets.containsKey(userId)) queue.add(new int[]{userId, tweets.get(userId).size() - 1});
        if (follower.containsKey(userId))
            for (int followeeId : follower.get(userId))
                if (tweets.containsKey(followeeId))
                    queue.add(new int[]{followeeId, tweets.get(followeeId).size() - 1});

        List<Integer> result = new ArrayList<>();
        while (result.size() < 10 && !queue.isEmpty()) {
            int[] root = queue.poll();
            result.add(tweets.get(root[0]).get(root[1]));
            if (root[1] > 0) {
                root[1]--;
                queue.add(root);
            }
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId)
            follower.computeIfAbsent(followerId, id -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (follower.containsKey(followerId))
            follower.get(followerId).remove(followeeId);
    }
}