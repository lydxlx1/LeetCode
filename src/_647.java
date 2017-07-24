/**
 * LeetCode 647 - Palindromic Substrings
 * <p>
 * DP
 */
public class _647 {
    Boolean[][] f;

    private boolean f(String s, int i, int j) {
        if (i >= j) return true;
        f[i][j] = s.charAt(i) == s.charAt(j) && f(s, i + 1, j - 1);
        return f[i][j];
    }

    public int countSubstrings(String s) {
        int n = s.length();
        f = new Boolean[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (f(s, i, j))
                    ans++;
        return ans;
    }
}