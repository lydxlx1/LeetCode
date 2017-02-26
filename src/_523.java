import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 523 - Continuous Subarray Sum
 * <p>
 * Prefix-sum approach
 * Pay EXTREME attention to the case when
 * 1) k = 0
 * 2) k is negative
 * 3) abs(k) is large
 */
public class _523 {

    public boolean checkSubarraySum(int[] nums, int kk) {
        long k = kk, sum = 0;
        if (k == 0) k = Integer.MIN_VALUE;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
