/**
 * Shortest Common Supersequence
 *
 * DP + Backtracking
 * Very similar to finding the longest subsequence of two strings.
 */
public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        // Shift the index by one for convenience
        str1 = " " + str1; // [1..n]
        str2 = " " + str2; // [1..m]

        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + 1;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        int i = n, j = m;
        while (i > 0 || j > 0) {
            if (i == 0) {
                builder.append(str2.charAt(j--));
            } else if (j == 0) {
                builder.append(str1.charAt(i--));
            } else {
                if (str1.charAt(i) == str2.charAt(j)) {
                    builder.append(str1.charAt(i));
                    i--;
                    j--;
                } else if (f[i][j - 1] < f[i - 1][j]) {
                    builder.append(str2.charAt(j--));
                } else {
                    builder.append(str1.charAt(i--));
                }
            }
        }
        return builder.reverse().toString();
    }
}
