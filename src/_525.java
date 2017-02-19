import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 525 - Contiguous Array
 * <p>
 * 1. Map each 0 to -1
 * 2. Compute the prefix sum array
 * 3. Find the longest subarray [l, r] such that prefix(l) == prefix(r), then the answer is r - l.
 * 4. prefix[-1] = 0.
 */
public class _525 {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) ans = Math.max(ans, i - map.get(sum));
            else map.put(sum, i);
        }
        return ans;
    }
}


