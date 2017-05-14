/**
 * LeetCode 583 - Delete Operation for Two Strings
 * <p>
 * LCS
 */
public class _583 {
    public int minDistance(String a, String b) {
        int[][] f = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++)
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        return a.length() + b.length() - 2 * f[a.length()][b.length()];
    }
}