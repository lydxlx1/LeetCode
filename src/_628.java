import java.util.Arrays;

/**
 * LeetCode 628 - Maximum Product of Three Numbers
 * <p>
 * It is not difficult to prove the largest product must be the product of a prefix and a suffix.
 */
public class _628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        ans = Math.max(ans, nums[0] * nums[1] * nums[2]);
        ans = Math.max(ans, nums[0] * nums[1] * nums[n - 1]);
        ans = Math.max(ans, nums[0] * nums[n - 2] * nums[n - 1]);
        ans = Math.max(ans, nums[n - 3] * nums[n - 2] * nums[n - 1]);
        return ans;
    }
}