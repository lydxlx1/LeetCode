/**
 * LeetCode 877 - Stone Game
 * <p>
 * DP
 */
public class _877 {

    Integer[][] f;
    int[] piles;
    int[] s;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        f = new Integer[n][n];
        this.piles = piles;
        s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = (i > 0 ? s[i - 1] : 0) + piles[i];
        }
        int alex = f(0, n - 1);
        int lee = s[n - 1] - alex;
        return alex > lee;
    }

    int f(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int sum = s[j] - s[i] + piles[i];
        int a = piles[i] + (sum - f(i + 1, j));
        int b = piles[j] + (sum - f(i, j - 1));
        f[i][j] = Math.max(a, b);
        return f[i][j];
    }
}

