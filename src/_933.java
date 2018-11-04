import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 933 - Number of Recent Calls
 *
 * Monotone Queue
 */
public class _933 {

    Deque<Integer> queue = new ArrayDeque<>();

    public _933() {

    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.getLast() - queue.getFirst() > 3000) {
            queue.removeFirst();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */