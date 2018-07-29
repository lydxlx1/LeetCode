/**
 * LeetCode 879 - Profitable Schemes
 * <p>
 * DP
 */
public class _879 {

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int[][] f = new int[G + 1][P + 1];
        f[0][0] = 1;

        int ans = 0, mod = 1000000007;
        for (int i = 0; i < group.length; i++) {
            int[][] g = new int[G + 1][P + 1];
            for (int j = 0; j <= G; j++)
                for (int k = 0; k <= P; k++)
                    g[j][k] = f[j][k];

            for (int j = 0; j + group[i] <= G; j++) {
                for (int k = 0; k <= P; k++) {
                    g[j + group[i]][Math.min(P, k + profit[i])] += f[j][k];
                    g[j + group[i]][Math.min(P, k + profit[i])] %= mod;
                }
            }
            f = g;
        }

        for (int i = 0; i <= G; i++) {
            ans += f[i][P];
            ans %= mod;
        }
        return ans;
    }
}

