import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode 346 - Moving Average from Data Stream
 * <p>
 * Sliding window
 */
public class _346 {

    Queue<Integer> queue;
    int size;
    long sum;

    /**
     * Initialize your data structure here.
     */
    public _346(int size) {
        this.size = size;
        queue = new ArrayDeque<>();
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() >= size) sum -= queue.poll();
        queue.add(val);
        sum += val;
        return (double) sum / queue.size();
    }
}