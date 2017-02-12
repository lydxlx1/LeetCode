import java.util.Arrays;

/**
 * LeetCode 493 - Reverse Pairs
 * <p>
 * Merge-sort based solution
 * Shorter
 * But the runtime is O(n log^2 n), total space is O(n log n), and peak space is O(n).
 */
public class _493_1 {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int[] a = Arrays.copyOf(nums, n / 2), b = Arrays.copyOfRange(nums, n / 2, n);
        int ans = reversePairs(a) + reversePairs(b);
        for (int i = 0, j = 0; i < a.length; i++) {
            while (j < b.length && a[i] > 2L * b[j]) j++;
            ans += j;
        }
        Arrays.sort(nums);
        return ans;
    }
}


