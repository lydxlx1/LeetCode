import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * LeetCode 918 - Maximum Sum Circular Subarray
 *
 * Sliding Window + TreeMap
 */
public class _918_1 {

    class SlidingWindow {
        int limit;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        public SlidingWindow(int limit) {
            this.limit = limit;
        }

        public int getMin() {
            return treeMap.firstKey();
        }

        public void add(int x) {
            if (queue.size() == limit) {
                int val = queue.poll();
                treeMap.put(val, treeMap.get(val) - 1);
                if (treeMap.get(val) == 0) {
                    treeMap.remove(val);
                }
            }
            treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
            queue.add(x);
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

