/**
 * LeetCode 891 - Super Egg Drop
 * <p>
 * DP with binary search optimization
 */
public class _887 {

    public int superEggDrop(int K, int N) {
        int[][] f = new int[K + 1][N + 1];

        for (int j = 0; j <= N; j++) {
            f[1][j] = j;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                f[i][j] = Integer.MAX_VALUE;

                // Here, it looks like we can perform ternary search on the function Math.max(f[i - 1][k - 1], f[i][j - k])
                // to find its minimal. However, this could be wrong as this function is not strictly increasing or decreasing
                // on each side.
                int left = 1, right = j;
                while (right - left > 10) {
                    int mid = (left + right) / 2;
                    if (f[i - 1][mid - 1] < f[i][j - mid]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }

                for (int k = left; k <= right; k++) {
                    f[i][j] = Math.min(f[i][j], 1 + Math.max(f[i - 1][k - 1], f[i][j - k]));
                }
            }
        }

        return f[K][N];
    }
}

