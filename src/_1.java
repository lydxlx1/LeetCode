import java.util.Arrays;

/**
 * LeetCode 1 - Two Sum
 *
 * O(n log n) - using two pointers
 */
public class _1 {
    public int[] twoSum(int[] nums, int target) {
        Integer[] sorted = new Integer[nums.length];
        for (int i = 0; i < sorted.length; i++) sorted[i] = i;
        Arrays.sort(sorted, (u, v) -> Integer.compare(nums[u], nums[v]));
        for (int i = 0, j = nums.length - 1; i < j; )
            if (nums[sorted[i]] + nums[sorted[j]] == target) return new int[]{sorted[i], sorted[j]};
            else if (nums[sorted[i]] + nums[sorted[j]] > target) j--;
            else i++;
        return null;
    }
}
