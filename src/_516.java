import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 516 - Longest Palindromic Subsequence
 * <p>
 * O(n^2) DP
 */
public class _516 {
    Integer[][] f;

    private int F(int i, int j, String s) {
        if (i > j) return 0;
        if (f[i][j] != null) return f[i][j];
        int ans = Math.max(F(i + 1, j, s), F(i, j - 1, s));
        if (s.charAt(i) == s.charAt(j)) ans = Math.max(ans, F(i + 1, j - 1, s) + (i == j ? 1 : 2));
        f[i][j] = ans;
        return ans;
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        f = new Integer[n][n];
        return F(0, s.length() - 1, s);
    }
}
