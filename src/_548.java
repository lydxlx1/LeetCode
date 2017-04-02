import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * LeetCode 548 - Split Array with Equal Sum
 * <p>
 * Enumerate j first, taking O(n) time.
 * Then the problem becomes two independent two sub-problems, each of which takes O(n) time.
 * So, the total runtime is O(n^2).
 */
public class _548 {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        BiFunction<Integer, Integer, Integer> sum = (i, j) -> i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];

        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i + 1 < j; i++) {
                int cb = sum.apply(0, i - 1);
                int wb = sum.apply(i + 1, j - 1);
                if (cb == wb) set.add(cb);
            }

            for (int k = j + 2; k + 1 < n; k++) {
                int cb = sum.apply(j + 1, k - 1);
                int wb = sum.apply(k + 1, n - 1);
                if (cb == wb && set.contains(cb)) return true;
            }
        }

        return false;
    }
}
