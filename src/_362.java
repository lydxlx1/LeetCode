import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * LeetCode 362 - Design Hit Counter
 * <p>
 * Sliding Window
 * O(1) space, query
 */
public class _362 {

    public static final int STALE_SEC = 300;

    int totalHits = 0;
    Deque<int[]> queue = new ArrayDeque<>();

    /**
     * Initialize your data structure here.
     */
    public _362() {
    }

    private void kick(int ts) {
        while (!queue.isEmpty() && ts - queue.peek()[0] >= STALE_SEC) totalHits -= queue.poll()[1];
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        kick(timestamp);
        if (!queue.isEmpty() && queue.peekLast()[0] == timestamp) queue.peekLast()[1]++;
        else queue.addLast(new int[]{timestamp, 1});
        totalHits++;

    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        kick(timestamp);
        return totalHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */