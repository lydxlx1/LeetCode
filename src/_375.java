/**
 * LeetCode 375 - Guess Number Higher or Lower II
 * <p>
 * O(n^3) DP
 */
public class _375 {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 2][n + 2];
        // dp on f[1..n][1..n]
        // but will refer to  f[X][0] and f[n+1][X]
        for (int d = 1; d < n; d++)
            for (int i = 1; i <= n; i++) {
                int j = i + d;
                if (j > n) break;
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
            }
        return f[1][n];
    }
}
