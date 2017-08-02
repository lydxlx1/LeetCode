/**
 * LeetCode 644 - Maximum Average Subarray II
 * <p>
 * Binary Search + Sliding windows
 * <p>
 * Use the binary search to guess the final answer and convert the problem into a decision version:
 * Determine whether there is a subarray of length at least k that has average >= avg.
 * <p>
 * avg(a[l..r]) >= x, iff
 * a[l..r] >= (r - l + 1) * x, iff
 * (a[l] - x) + (a[l+1] - x) + ... + (a[r] - x) >= 0.
 * <p>
 * Define a new array b[], where b[i] = a[i] - x.
 * Then, it is equivalent to ask whether there exists a subarray of b whose length is >= k and whose sum is >= 0.
 * <p>
 * This problem can be solved by the sliding window method on the prefix sum array of b.
 */
public class _644 {
    private boolean isok(int[] a, double avg, int k) {
        double min = 0;
        double[] prefixSum = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + a[i] - avg;
            if (i >= k - 1) {
                if (prefixSum[i] - min >= 0) return true;
                min = Math.min(min, prefixSum[i - k + 1]);
            }
        }

        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double left = -10000, right = 10000;
        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            if (isok(nums, mid, k)) left = mid;
            else right = mid;
        }
        return left;
    }
}