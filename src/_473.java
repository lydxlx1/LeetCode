import java.util.Arrays;

/**
 * LeetCode 473 - Matchsticks to Square
 * <p>
 * Backtracking
 * <p>
 * Enumerate three pairwise-disjoint subsets of the matches and try to see whether the sum of each partition is
 * equal to the length of the square. Some pruning techniques can be applied:
 * <p>
 * 1. At least one edge belongs to the current partition.
 * 2. Without loss of generality, assume the longest available match is always selected.
 * The can be done via a global sorting.
 * 3. Bit trick can be applied when enumerating the current subset from the remaining matches.
 */
public class _473 {
    int sum = 0, len = 0;

    private boolean dfs(int t, int[] a) {
        if (t >= 3) return true;
        int n = a.length;
        // The largest element is always in the current partition
        if (a[n - 1] > len) return false;
        for (int i = 0; i < (1 << (n - 1)); i++) {
            int s = 0;
            for (int j = 0; j < n - 1; j++)
                if (((1 << j) & i) != 0) s += a[j];
            if (s + a[n - 1] == len) {
                int[] b = new int[n - 1 - Integer.bitCount(i)];
                for (int j = 0, k = 0; j < n - 1; j++)
                    if (((1 << j) & i) == 0) b[k++] = a[j];
                if (dfs(t + 1, b)) return true;
            }
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        len = sum / 4;

        Arrays.sort(nums);
        return dfs(0, nums);
    }
}