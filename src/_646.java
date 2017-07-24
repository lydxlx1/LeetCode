import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode 646
 * <p>
 * Maximum Length of Pair Chain
 * <p>
 * Sweepline algorithm
 */
public class _646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(u -> u[1]));
        int ans = 1, end = pairs[0][1];
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                ans++;
                end = pair[1];
            }
        }
        return ans;
    }
}