/**
 * LeetCode 730 - Count Different Palindromic Subsequences
 * <p>
 * For each unique palindromic, say (a, b, c, ..., c, b, a), we charge it to only one subsequence, by
 * 1) taking the leftmost s_i and right most s_j s.t. s_i = s_j = a,
 * 2) recursively finding the subsequence in s[i+1 .. j - 1] w.r.t. to (b, c, ..., c, b).
 */
public class _730 {
    final int MOD = 1000000007;

    Integer[][] f;
    char[] s;

    // Count the # of unique (non-empty) palindromic subsequences of s[i..j].
    private int f(int i, int j) {
        if (f[i][j] == null) {
            long ans = 0;

            // Enumerate the outer-most character of the palindrome.
            for (char ch = 'a'; ch <= 'd'; ch++) {
                int ii = i, jj = j;
                while (ii < s.length && s[ii] != ch) ii++;
                while (jj >= 0 && s[jj] != ch) jj--;
                if (ii <= jj) {
                    if (ii == jj) ans++; // only [ch]
                    else {
                        ans += 2;  // [ch] and [ch, ch]
                        if (ii + 1 < jj) ans += f(ii + 1, jj - 1);
                    }
                }
            }
            f[i][j] = (int) (ans % MOD);
        }
        return f[i][j];
    }

    public int countPalindromicSubsequences(String S) {
        s = S.toCharArray();
        f = new Integer[s.length][s.length];
        return f(0, s.length - 1);
    }
}