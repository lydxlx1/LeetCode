import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 493 - Reverse Pairs
 * <p>
 * Solution using BIT
 * <p>
 * First time to know we can write a BIT without discretization.
 * In fact, each update operation will add at most log U entries, where U is the universe size.
 * Each query will again trigger at most log U entries.
 */
public class _493_2 {

    Map<Long, Integer> bit;

    private void add(long x) {
        for (x += 1L << 31; x < (1L << 33); x += Long.lowestOneBit(x)) bit.put(x, bit.getOrDefault(x, 0) + 1);
    }

    private int query(long x) {
        int ans = 0;
        for (x += 1L << 31; x > 0; x -= Long.lowestOneBit(x)) ans += bit.getOrDefault(x, 0);
        return ans;
    }

    public int reversePairs(int[] nums) {
        bit = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            ans += query(Integer.MAX_VALUE) - query(2L * num);
            add(num);
        }
        return ans;
    }
}


