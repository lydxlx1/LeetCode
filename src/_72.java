/**
 * LeetCode 72 - Edit Distance
 *
 * O(nm) DP
 */
public class _72 {
    public int minDistance(String a, String b) {
        int[][] f = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) f[i][b.length()] = a.length() - i;
        for (int j = 0; j <= b.length(); j++) f[a.length()][j] = b.length() - j;
        for (int i = a.length() - 1; i >= 0; i--)
            for (int j = b.length() - 1; j >= 0; j--)
                if (a.charAt(i) == b.charAt(j)) f[i][j] = f[i + 1][j + 1];
                else f[i][j] = Math.min(Math.min(f[i + 1][j], f[i][j + 1]), f[i + 1][j + 1]) + 1;
        return f[0][0];
    }
}
