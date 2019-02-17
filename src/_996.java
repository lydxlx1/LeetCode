import java.util.Arrays;

/**
 * LeetCode 996 - Number of Squareful Arrays
 *
 * Hamiltonian Path
 * Some special effort is needed to avoid double counting paths that look the same.
 */
public class _996 {

    boolean[][] g;

    public int numSquarefulPerms(int[] A) {
        int n = A.length;

        Arrays.sort(A);
        g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = isSquare(A[i] + A[j]);
            }
        }

        int[][] f = new int[1 << n][n];
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if ((mask - (1 << i)) == 0) {
                        f[mask][i] = 1;
                    } else {
                        int last = -1; // Avoid double counting
                        for (int pre = 0; pre < n; pre++) {
                            if (g[pre][i] && pre != i && (mask & (1 << pre)) != 0 && last != A[pre]) {
                                f[mask][i] += f[mask - (1 << i)][pre];
                                last = A[pre];
                            }
                        }
                    }
                }
            }
        }

        int ans = 0, last = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] != last) {
                ans += f[(1 << n) - 1][i];
                last = A[i];
            }
        }
        return ans;
    }

    boolean isSquare(int x) {
        long root = (int) Math.sqrt(x);
        return root * root == x || (root - 1) * (root - 1) == x || (root + 1) * (root + 1) == x;
    }
}

