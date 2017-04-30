import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560 - Subarray Sum Equals K
 * <p>
 * Prefix-sum trick
 */
public class _560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            prefix += num;
            ans += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}