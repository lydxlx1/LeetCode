import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 594 - Longest Harmonious Subsequence
 * <p>
 * Brute-force via HashMap
 */
public class _594 {
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums)
            if (map.containsKey(num + 1))
                ans = Math.max(ans, map.get(num) + map.get(num + 1));
        return ans;
    }
}
