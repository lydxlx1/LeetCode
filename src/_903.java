import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode 903 - Valid Permutations for DI Sequence
 *
 * DP solution by enumerating where to place the smallest element
 */
public class _903 {

    static int MOD = 1000000007;
    Map<String, Integer> f = new HashMap<>();

    static int[][] choose = new int[222][];

    static {
        for (int i = 0; i < choose.length; i++) {
            choose[i] = new int[i + 1];
            choose[i][0] = choose[i][i] = 1;
            for (int j = 1; j < i; j++) {
                choose[i][j] = (choose[i - 1][j] + choose[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int numPermsDISequence(String S) {
        if (S.isEmpty()) {
            return 1;
        }
        if (f.containsKey(S)) {
            return f.get(S);
        }

        // We enumerate the position to place smallest number.
        int ans = 0;
        if (S.startsWith("I")) {
            ans += numPermsDISequence(S.substring(1));
            ans %= MOD;
        }
        if (S.endsWith("D")) {
            ans += numPermsDISequence(S.substring(0, S.length() - 1));
            ans %= MOD;
        }

        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == 'D' && S.charAt(i + 1) == 'I') {
                //  ...DI...
                //     ^
                //     i
                // In total, we need fill S.length() + 1 numbers. After the smallest number is placed,
                // there are S.length() numbers left, where i+1 of them are to the left.
                long prod = choose[S.length()][i + 1];
                ;
                prod *= numPermsDISequence(S.substring(0, i));
                prod %= MOD;
                prod *= numPermsDISequence(S.substring(i + 2, S.length()));
                prod %= MOD;

                ans += (int) prod;
                ans %= MOD;
            }
        }

        f.put(S, ans);
        return ans;
    }
}

