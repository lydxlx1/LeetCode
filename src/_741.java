import java.util.Arrays;

/**
 * LeetCode 741 - Cherry Pickup
 * <p>
 * Very good DP problem.
 * The original problem can be viewed as two person simultaneously go from the top-left corner to the bottom-right corner,
 * where the cherry on the same cell can only be picked up once.
 * <p>
 * Let these two people walk in the SAME speed. Then a very critical observation is that if the two people meet at some
 * location, they must spend the same amount of time.
 * So, we can define f[t][i][j] as the max # of cherries the two people can pick, where
 * 1) they have walked t steps, and at the end,
 * 2) the first people is at the i-th row,
 * 3) the second people is at the j-th row.
 * The column indices can be computed accordingly.
 * <p>
 * The DP recurrence can be found in the following code.
 */
public class _741 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] f = new int[2 * n - 1][n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == -1)
                    grid[i][j] = -10000;

        for (int i = 0; i < f.length; i++)
            for (int j = 0; j < f[i].length; j++)
                Arrays.fill(f[i][j], -10000);
        f[0][0][0] = grid[0][0];

        for (int t = 1; t < f.length; t++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (t - i >= 0 && t - i < n && t - j >= 0 && t - j < n) {
                        // If they are at the same position, only collect one cherry.
                        int val = i == j ? grid[i][t - i] : grid[i][t - i] + grid[j][t - j];

                        int ans = f[t - 1][i][j] + val;
                        if (j - 1 >= 0)
                            ans = Math.max(ans, f[t - 1][i][j - 1] + val);
                        if (i - 1 >= 0)
                            ans = Math.max(ans, f[t - 1][i - 1][j] + val);
                        if (i - 1 >= 0 && j - 1 >= 0)
                            ans = Math.max(ans, f[t - 1][i - 1][j - 1] + val);

                        f[t][i][j] = ans;
                    }
                }

        return Math.max(f[2 * n - 2][n - 1][n - 1], 0);
    }
}