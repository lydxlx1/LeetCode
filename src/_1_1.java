import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1 - Two Sum
 * <p>
 * O(n) - using Hash Table
 * Beat 98.70%
 */
public class _1_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer hehe = map.get(target - nums[i]);
            if (hehe != null) return new int[]{hehe, i};
            map.put(nums[i], i);
        }
        return null;
    }
}
