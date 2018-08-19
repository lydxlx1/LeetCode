/**
 * LeetCode 884 - Decoded String at Index
 * <p>
 * DP
 */
public class _880 {

    public String decodeAtIndex(String S, int K) {
        // f[i] is the length of expanded string of S[0..i].
        long[] f = new long[S.length()];
        f[0] = 1;
        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (Character.isDigit(ch)) {
                f[i] = f[i - 1] * (ch - '0');
            } else {
                f[i] = f[i - 1] + 1;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (Character.isDigit(ch)) {
                K = (int) ((K - 1) % f[i - 1] + 1);
            } else {
                if (K == f[i]) {
                    return "" + S.charAt(i);
                }
            }
        }
        throw new RuntimeException();
    }
}

