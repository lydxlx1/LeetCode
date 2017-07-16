/**
 * LeetCode 643 - Maximum Average Subarray I
 * <p>
 * Simply sliding window problem
 */
public class _643 {
    public double findMaxAverage(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) maxSum = Math.max(maxSum, sum);
        }
        return maxSum * 1.0 / k;
    }
}
