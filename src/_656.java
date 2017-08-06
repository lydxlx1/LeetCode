import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 656 - Coin Path
 * <p>
 * DP
 * Printing the lexicographically smallest solution is indeed more interesting.
 * <p>
 * Let dp[i] denote the smallest cost jumping from location i to n.
 * This recurrence can guarantee the optimality of the output sequence.
 * <p>
 * <p>
 * If dp[i] denote the smallest cost jumping from location 1 to i, we cannot guarantee the output correctness.
 */
public class _656 {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] dp = new int[n];
        int[] next = new int[n];
        final int INF = Integer.MAX_VALUE / 2;

        dp[n - 1] = A[n - 1] == -1 ? INF : A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = INF;
            if (A[i] != -1) {
                for (int j = i + 1; j < n && j <= i + B; j++) {
                    if (dp[j] < INF && A[i] + dp[j] < dp[i]) {
                        dp[i] = A[i] + dp[j];
                        next[i] = j;
                    }
                }
            }
        }

        if (dp[0] < INF) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i != n - 1; i = next[i]) {
                res.add(i + 1);
            }
            res.add(n);
            return res;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public static void main(String[] args) {
        _656 sol = new _656();
        System.out.println(sol.cheapestJump(new int[]{1, 2, 4, -1, 2}, 2));
    }
}