import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode 359 - Logger Rate Limiter
 * <p>
 * Assume timestamps of messages are given in non-decreasing order.
 * Then, we can keep a sliding window and store only limited amount of logs.
 */
public class _359_1 {

    static class Log {
        String msg;
        int ts;

        public Log(String msg, int ts) {
            this.msg = msg;
            this.ts = ts;
        }
    }

    Queue<Log> queue;
    Set<String> visited;

    /**
     * Initialize your data structure here.
     */
    public _359_1() {
        queue = new ArrayDeque<>();
        visited = new HashSet<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty() && timestamp - queue.peek().ts >= 10) visited.remove(queue.poll().msg);
        if (!visited.contains(message)) {
            visited.add(message);
            queue.add(new Log(message, timestamp));
            return true;
        } else return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */