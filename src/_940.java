/**
 * LeetCode 940 - Distinct Subsequence II
 *
 * DP
 */
public class _940 {

    public int distinctSubseqII(String S) {
        int mod = 1000000007;
        int n = S.length();
        S = ' ' + S; // Now, we consider S[1..n] instead.

        int[] f = new int[S.length()];
        int[] last = new int[128];

        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 1]) % mod;
            char ch = S.charAt(i);
            if (last[ch] > 0) {
                f[i] += mod - (f[last[ch] - 1]); // Need to shift the index by one because the character at S[last[ch]] must present.
                f[i] %= mod;
            }
            last[ch] = i;
        }

        return (f[n] - 1 + mod) % mod;
    }
}

