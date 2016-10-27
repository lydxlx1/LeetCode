import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 325 - Maximum Size Subarray Sum Equals k
 * <p>
 * O(n) solution using prefixSum and hash table
 */
public class _325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0, prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) ans = Math.max(ans, i - map.get(prefixSum - k));
            map.putIfAbsent(prefixSum, i);
        }
        return ans;
    }
}