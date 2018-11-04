import java.util.Arrays;

/**
 * LeetCode 935 - Knight Dialer
 *
 * DP
 * The runtime can also be optimized to O(log n) using fast matrics powering.
 */
public class _935 {

    int[][] next = {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4},
    };

    public int knightDialer(int N) {
        int mod = 1000000007;
        int[][] f = new int[N + 1][10];

        Arrays.fill(f[1], 1);
        for (int i = 1; i < N; i++) {
            for (int u = 0; u < 10; u++) {
                for (int v : next[u]) {
                    f[i + 1][v] += f[i][u];
                    f[i + 1][v] %= mod;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += f[N][i];
            ans %= mod;
        }
        return ans;
    }
}

