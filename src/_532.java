import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 532 - K-diff Pairs in an Array
 * <p>
 * Linear solution
 */
public class _532 {

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // Pay extreme attention to this.

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (map.containsKey(i + k)) {
                int cb = map.get(i);
                if (i + k != i) cb += map.get(i + k);
                if (cb >= 2) set.add(i);
            }
        }
        return set.size();
    }
}