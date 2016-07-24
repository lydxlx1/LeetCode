import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 373 - Find K Pairs with Smallest Sums
 * <p>
 * O(k * log(min(k, m, n) + min(k, m, n)) using min-heap
 * <p>
 * Use a heap to maintain min(k, m, n) pointers. When extracting an element from the heap, we move the pointer forward
 * and insert it back into the heap again.
 */
public class _373 {
    public List<int[]> kSmallestPairs(int[] a, int[] b, int k) {
        if (a.length == 0 || b.length == 0) return new ArrayList<>();
        List<int[]> ans = new ArrayList<>(k);
        int[] ptr = new int[Math.min(k, a.length)]; // Here, I just assume a.length is always less than b.length
        PriorityQueue<Integer> queue = new PriorityQueue<>((u, v) -> Integer.compare(a[u] + b[ptr[u]], a[v] + b[ptr[v]]));
        for (int i = 0; i < ptr.length; i++) queue.add(i);
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            int u = queue.poll();
            ans.add(new int[]{a[u], b[ptr[u]]});
            if (ptr[u] + 1 < b.length) {
                ptr[u]++;
                queue.add(u);
            }
        }
        return ans;
    }
}
