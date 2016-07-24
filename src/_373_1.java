import java.util.*;

/**
 * LeetCode 373 - Find K Pairs with Smallest Sums
 * <p>
 * O(k * log k) algorithm using min-heap
 * <p>
 * Initially, insert (0, 0) into the heap.
 * When (i, j) is extracted from the heap, we insert (i + 1, j) and (i, j + 1) into the heap.
 * Remember to use a hash table to guarantee each pair is only inserted for once.
 */
public class _373_1 {
    public List<int[]> kSmallestPairs(int[] a, int[] b, int k) {
        List<int[]> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((u, v) -> Integer.compare(a[u[0]] + b[u[1]], a[v[0]] + b[v[1]]));
        Set<Integer> hash = new HashSet<>();

        if (a.length > 0 && b.length > 0) queue.add(new int[]{0, 0});
        while (queue.size() > 0 && ans.size() < k) {
            int[] pair = queue.poll();
            if (hash.contains(pair[0] * b.length + pair[1])) continue;
            else hash.add(pair[0] * b.length + pair[1]);
            ans.add(new int[]{a[pair[0]], b[pair[1]]});
            if (pair[0] + 1 < a.length) queue.add(new int[]{pair[0] + 1, pair[1]});
            if (pair[1] + 1 < b.length) queue.add(new int[]{pair[0], pair[1] + 1});
        }
        return ans;
    }
}
