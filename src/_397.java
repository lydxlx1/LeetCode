import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.function.LongConsumer;

/**
 * LeetCode 397 - Integer Replacement
 * <p>
 * BFS to find the shortest path
 */
public class _397 {
    public int integerReplacement(int n) {
        Map<Long, Integer> dist = new HashMap<>();
        Queue<Long> queue = new ArrayDeque<>();
        queue.add((long) n);
        dist.put((long) n, 0);
        while (!queue.isEmpty()) {
            long x = queue.poll();
            if (x == 1) return dist.get(x);

            LongConsumer push = num -> {
                if (!dist.containsKey(num)) {
                    queue.add(num);
                    dist.put(num, dist.get(x) + 1);
                }
            };
            if (x % 2 == 0) push.accept(x / 2);
            else {
                push.accept(x + 1);
                push.accept(x - 1);
            }
        }
        return -1;
    }
}