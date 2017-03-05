import java.util.Arrays;

/**
 * LeetCode 532 - K-diff Pairs in an Array
 * <p>
 * Two-pointer approach
 */
public class _532_1 {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (j = Math.max(j, i + 1); j < nums.length && nums[j] - nums[i] < k; j++) ;
            if (j < nums.length && nums[j] - nums[i] == k) ans++;
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return ans;
    }
}
