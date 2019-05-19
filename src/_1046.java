import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 1046 - Last Stone Weight
 *
 * Heap
 */
public class _1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> a = new PriorityQueue<>(Comparator.<Integer>comparingInt(i -> i).reversed());
        for (int i : stones) {
            a.add(i);
        }
        while (a.size() > 1) {
            int y = a.poll();
            int x = a.poll();
            if (x < y) {
                a.add(y - x);
            }
        }
        return a.isEmpty() ? 0 : a.poll();
    }
}
