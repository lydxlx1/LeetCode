/**
 * LeetCode 639 - Decode Ways II
 * <p>
 * Counting Problem
 * <p>
 * This problem can be solved by using DP.
 * Please pay attention to the following cases:
 * <p>
 * 1. 0xxx is invalid.
 * 2. * cannot match 0.
 */
public class _639 {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0; // This is evil...
        int mod = 1000000007;
        int[] f = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 10; j++) {
                // Note that * cannot match 0
                if (s.charAt(i) - '0' == j || (j > 0 && s.charAt(i) == '*')) {
                    // Decode one digit
                    if (j > 0) {
                        f[i] = (f[i] + (i - 1 >= 0 ? f[i - 1] : 1)) % mod;
                    }

                    // Decode two digit
                    if (i > 0) {
                        for (int k = 1; k <= 2; k++) {
                            int val = k * 10 + j;
                            boolean valInRange = val >= 10 && val <= 26;
                            boolean kIsValid = s.charAt(i - 1) - '0' == k || s.charAt(i - 1) == '*';
                            if (valInRange && kIsValid) {
                                f[i] = (f[i] + (i - 2 >= 0 ? f[i - 2] : 1)) % mod;
                            }
                        }
                    }
                }
            }
        }
        return f[s.length() - 1];
    }
}