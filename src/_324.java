import java.util.Arrays;

/**
 * LeetCode 324 - Wiggle Sort II
 *
 * Median Finding, Dutch National Flag
 *
 * For more information, refer to
 *
 * https://leetcode.com/discuss/77133/o-n-o-1-after-median-virtual-indexing
 * https://leetcode.com/discuss/77115/o-n-time-o-1-space-solution-with-detail-explanations
 */
public class _324 {

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Re-index
     * [0, 1, 2, 3, 4, 5] ->
     * [1, 3, 5, 0, 2, 4]
     *
     * [0, 1, 2, 3, 4, 5, 6] ->
     * [1, 3, 5, 0, 2, 4, 6]
     */
    private int map(int i, int n) {
        return i < n / 2 ? 2 * i + 1 : 2 * (i - n / 2);
    }

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n / 2]; // Can be done in O(n) time and O(1) space.
        int i = 0, j = 0;
        // After this partition, the array looks like (without considering the map)
        // [ > median] [ = median] [ < median]
        for (int k = 0; k < n; k++)
            if (nums[map(k, n)] > median) {
                swap(nums, map(j++, n), map(k, n));
                swap(nums, map(i++, n), map(j - 1, n));
            } else if (nums[map(k, n)] == median) {
                swap(nums, map(j++, n), map(k, n));
            }
    }
}