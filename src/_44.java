/**
 * LeetCode 44 - Wildcard Matching
 *
 * O(nm) dp
 */
public class _44 {
    public boolean isMatch(String s, String p) {
        int r = s.length(), c = p.length();
        boolean[][] f = new boolean[r + 1][c + 1];

        f[0][0] = true;
        for (int j=1; j<=c; j++) f[0][j] = f[0][j - 1] && p.charAt(j - 1) == '*';

        for (int i=1; i<=r; i++)
            for (int j=1; j<=c; j++)
                if (p.charAt(j - 1) == '*') f[i][j] = f[i - 1][j] || f[i][j - 1];
                else f[i][j] = f[i - 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));

        return f[r][c];
    }
}