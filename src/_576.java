/**
 * LeetCode 576 - Out of Boundary Paths
 * <p>
 * DP
 */
public class _576 {
    Integer[][][] f;
    int m, n, N;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int MOD = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        this.m = m;
        this.n = n;
        this.N = N;
        f = new Integer[N][m][n];
        return F(0, i, j);
    }

    private int F(int t, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 1;
        if (t >= N)
            return 0;
        if (f[t][i][j] != null)
            return f[t][i][j];
        int ans = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            ans = (ans + F(t + 1, x, y)) % MOD;
        }
        f[t][i][j] = ans;
        return ans;
    }
}
