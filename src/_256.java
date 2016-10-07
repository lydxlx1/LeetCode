/**
 * LeetCode 256 - Paint House
 * <p>
 * O(nk^2) DP
 * We can further improve the runtime to O(nk).
 * For this problem, k = 3, which is small enough, even an O(nk^2) algorithm works pretty well.
 */
public class _256 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] f = new int[n][3];
        f[0] = costs[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++)
                    if (j != k) f[i][j] = Math.min(f[i][i], f[i - 1][k] + costs[i][j]);
            }
        }
        return Math.min(f[n - 1][0], Math.min(f[n - 1][1], f[n - 1][2]));
    }
}