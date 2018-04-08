import java.util.*;

/**
 * LeetCode 815 - Bus Routes
 * <p>
 * BFS
 * One thing to notice is that, for each bus, we only need to iterate once its stop list.
 */
public class _815 {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, Integer> dist = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Set<Integer>> busAtStop = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                busAtStop.putIfAbsent(stop, new HashSet<>());
                busAtStop.get(stop).add(i);
            }
        }

        dist.put(S, 0);
        queue.add(S);
        while (!queue.isEmpty()) {
            int head = queue.poll();
            if (head == T) {
                return dist.get(head);
            }

            for (int bus : busAtStop.get(head)) {
                for (int stop : routes[bus]) {
                    if (!dist.containsKey(stop)) {
                        dist.put(stop, dist.get(head) + 1);
                        queue.add(stop);
                    }
                }
                if (routes[bus].length > 0) {
                    routes[bus] = new int[0];
                }
            }
            busAtStop.get(head).clear();
        }

        return -1;
    }
}
