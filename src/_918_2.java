import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * LeetCode 918 - Maximum Sum Circular Subarray
 * <p>
 * Sliding-window + Monotonic Queue
 */
public class _918_2 {

    class SlidingWindow {
        int limit;
        Queue<Integer> queue = new ArrayDeque<>();
        Deque<Integer> monotonicQueue = new ArrayDeque<>();

        public SlidingWindow(int limit) {
            this.limit = limit;
        }

        public int getMin() {
            return monotonicQueue.getFirst();
        }

        public void add(int x) {
            if (queue.size() == limit) {
                int val = queue.poll();
                if (monotonicQueue.getFirst() == val) {
                    monotonicQueue.remove();
                }
            }
            queue.add(x);
            while (!monotonicQueue.isEmpty() && monotonicQueue.getLast() > x) {
                monotonicQueue.removeLast();
            }
            monotonicQueue.addLast(x);
        }
    }

    public int maxSubarraySumCircular(int[] A) {
        int ans = A[0];

        SlidingWindow window = new SlidingWindow(A.length);
        int maxWindowSize = A.length;

        A = IntStream.concat(IntStream.of(A), IntStream.of(A)).toArray();
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        window.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans, A[i] - window.getMin());
            window.add(A[i]);
        }

        return ans;
    }
}

