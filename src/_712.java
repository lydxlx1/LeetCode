/**
 * LeetCode 712 - Minimum ASCII Delete Sum for Two Strings
 * <p>
 * Just a DP solution similar to LCS
 */
public class _712 {
    public static void main(String[] args) {
        _712 sol = new _712();
        System.out.println(sol.minimumDeleteSum("sea", "eat"));
        System.out.println(sol.minimumDeleteSum("delete", "leet"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            f[i][0] = f[i - 1][0] + s1.charAt(i - 1);
        for (int j = 1; j <= m; j++)
            f[0][j] = f[0][j - 1] + s2.charAt(j - 1);
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i - 1][j] + s1.charAt(i - 1), f[i][j - 1] + s2.charAt(j - 1));
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
            }
        return f[n][m];
    }
}
