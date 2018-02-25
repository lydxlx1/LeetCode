/**
 * LeetCode 790 - Domino and Tromino Tiling
 * <p>
 * DP
 * <p>
 * f[i][0] = # of valid tilings given an entirely-empty 2 * i board
 * f[i][1] = # of valid tilings given an entirely-empty 2 * i board EXCEPT one corner is already tiled.
 */
public class _790 {

    public int numTilings(int N) {
        int mod = 1000000007;
        long[][] f = new long[N + 1][2];

        f[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            f[i][0] += f[i - 1][0];
            f[i][0] += f[i - 1][1] * 2;
            f[i][1] += f[i - 1][1];

            if (i - 2 >= 0) {
                f[i][0] += f[i - 2][0];
                f[i][1] += f[i - 2][0];
            }

            f[i][0] %= mod;
            f[i][1] %= mod;
        }
        return (int) (f[N][0]);
    }
}
