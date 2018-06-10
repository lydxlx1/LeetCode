import java.util.Arrays;

/**
 * LeetCode 851 - Loud and Rich
 * <p>
 * DAG
 */
public class _851 {

    boolean[][] g;
    int n;
    int[] ans;
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        this.quiet = quiet;
        n = quiet.length;
        g = new boolean[n][n];

        for (int[] row : richer) {
            g[row[0]][row[1]] = true;
        }

        ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            ans[i] = f(i);
        }
        return ans;
    }

    int f(int i) {
        if (ans[i] != -1) {
            return ans[i];
        }

        ans[i] = i;
        for (int j = 0; j < n; j++) {
            if (g[j][i] && quiet[f(j)] < quiet[ans[i]]) {
                ans[i] = f(j);
            }
        }
        return ans[i];
    }
}

