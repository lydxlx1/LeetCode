import java.util.*;
import java.util.stream.IntStream;

/**
 * LeetCode 967 - Numbers with Same Consecutive Differences
 *
 * Backtracking
 */
public class _967 {

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
            return IntStream.range(0, 10).toArray();
        } else {
            List<Integer> res = new ArrayList<>();
            dfs(0, 0, N, K, res);
            return res.stream().mapToInt(i -> i).toArray();
        }
    }

    void dfs(int t, int a, int N, int K, List<Integer> res) {
        if (t >= N) {
            res.add(a);
        } else {
            if (t == 0) {
                for (int i = 1; i <= 9; i++) {
                    dfs(t + 1, i, N, K, res);
                }
            } else {
                int lowbit = a % 10;
                if (lowbit + K < 10) {
                    dfs(t + 1, a * 10 + lowbit + K, N, K, res);
                }
                // Exclude the case when K == 0 to avoid generating duplicates.
                if (K != 0 && lowbit - K >= 0) {
                    dfs(t + 1, a * 10 + lowbit - K, N, K, res);
                }
            }
        }
    }
}

