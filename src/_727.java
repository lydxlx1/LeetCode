import java.util.Arrays;

/**
 * LeetCode 727 - Minimum Window Subsequence
 * <p>
 * DP
 * Assume Given S[1..n] and T[1..m].
 * <p>
 * Let f[i][j] be the length of the shortest suffix of S[1..i] that contains T[1..j] as a subsequence.
 * Then, f[i][j] = min(
 * f[i-1][j] + 1,
 * f[i-1][j-1] + 1, if S[i] == S[j]
 * )
 * <p>
 * Ans = min(f[i][m]), for 1 <= i <= n.
 * <p>
 * Time complexity = O(mn).
 * Space complexity = O(min(m, n)). But since the answer is trivial when len(T) > len(S), the space complexity can be written as O(m).
 * This also suggests that the algorithm works as well under the streaming model when T is relatively short but S is very long.
 */
public class _727 {
    public String minWindow(String S, String T) {
        int n = S.length(), m = T.length();
        int[][] f = new int[n + 1][m + 1];
        final int INF = 1 << 29;

        Arrays.fill(f[0], INF);
        f[0][0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j] + 1;
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }

        int minLen = INF, end = -1;
        for (int i = 1; i <= n; i++)
            if (f[i][m] < minLen) {
                minLen = f[i][m];
                end = i;
            }
        return minLen < INF ? S.substring(end - minLen, end) : "";
    }
}