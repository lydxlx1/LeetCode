import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 502 - IPO
 * <p>
 * Greedy
 * <p>
 * Use a max-priority-queue to maintain all feasible projects.
 * When W increases, include all those new feasible projects into the queue.
 */
public class _502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        List<Integer>[] a = new List[Capital.length];
        for (int i = 0; i < a.length; i++) a[i] = Arrays.asList(Profits[i], Capital[i]);
        Arrays.sort(a, Comparator.comparingInt(u -> u.get(1))); // increasing order of Capital
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((u, v) -> Integer.compare(u.get(0), v.get(0)) * -1); // decreasing order of Profit
        int i = 0;
        while (i < a.length && W >= a[i].get(1)) queue.add(a[i++]);
        while (!queue.isEmpty() && k > 0) {
            k--;
            W += queue.poll().get(0);
            while (i < a.length && W >= a[i].get(1)) queue.add(a[i++]);
        }
        return W;
    }
}
