/**
 * LeetCode 1043 - Partition Array for Maximum Sum
 *
 * DP
 */
public class _1043 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        return f(A, A.length - 1, K, new Integer[A.length]);
    }

    int f(int[] A, int i, int K, Integer[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        int ans = 0, max = 0;
        for (int j = i; j >= i - K + 1 && j >= 0; j--) {
            max = Math.max(max, A[j]);
            ans = Math.max(ans, max * (i - j + 1) + f(A, j - 1, K, memo));
        }
        memo[i] = ans;
        return ans;
    }
}
