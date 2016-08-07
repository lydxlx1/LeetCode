/**
 * LeetCode 10 - Regular Expression Matching
 *
 * O(nm) DP
 * f[i][j] means whether s[1..i] can be matched by pattern p[1..j].
 * Here, if p[j] is '*', then f[i][j] = f[i][j - 1].
 */
public class _10 {
    public boolean isMatch(String ss, String pp) {
        char[] s = ("!" + ss).toCharArray(), p = ("!" + pp).toCharArray();
        boolean[][] f = new boolean[s.length][p.length];

        f[0][0] = true;
        for (int j = 1; j < p.length; j += 2) {
            if (j + 1 < p.length && p[j + 1] == '*') {
                f[0][j] = f[0][j + 1] = true;
            } else break;
        }

        for (int i = 1; i < s.length; i++)
            for (int j = 1; j < p.length; j++)
                if (p[j] != '*') {
                    if (j + 1 < p.length && p[j + 1] == '*') {
                        boolean cb = f[i][j - 1]; // skip the *
                        boolean wb = f[i - 1][j] && (p[j] == '.' || s[i] == p[j]); // try to match at least one
                        f[i][j] = f[i][j + 1] = cb || wb;
                    } else {
                        f[i][j] = f[i - 1][j - 1] && (p[j] == '.' || s[i] == p[j]);
                    }
                }

        return f[s.length - 1][p.length - 1];
    }
}