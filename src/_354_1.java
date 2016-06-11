import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * LeetCode 354 - Russian Doll Envelopes
 *
 * O(n log n) DP
 * Longest Increasing Subsequence
 */
public class _354_1 {

    public int maxEnvelopes(int[][] g) {
        Arrays.sort(g, (u, v) -> u[0] == v[0] ? -Integer.compare(u[1], v[1]) : Integer.compare(u[0], v[0]));
        List<Integer> f = new ArrayList<>();
        for (int i = 0; i < g.length; i++)
            if (f.size() == 0 || f.get(f.size() - 1) < g[i][1]) f.add(g[i][1]);
            else {
                int left = -1, right = f.size() - 1;
                while (left + 1 < right) {
                    int mid = left + ((right - left) >> 1);
                    if (f.get(mid) < g[i][1]) left = mid;
                    else right = mid;
                }
                f.set(right, g[i][1]);
            }
        return f.size();
    }
}