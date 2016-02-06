import java.util.*;

/**
 * LeetCode 301 - Remove Invalid Parentheses
 *
 * DP
 *
 * Apply DP first to compute the minimum number of invalid parentheses to remove for any substring of s.
 * Then do a dfs to find all the optimal solutions based on the DP table.
 */
public class _301_1 {

    Set<String>[][] memo;

    private Set<String> dfs(int[][] f, int i, int j, String s) {
        if (memo[i][j] != null) return memo[i][j];

        Set<String> set = new HashSet<>();
        if (i > j) {
            set.add("");
        } else if (i == j) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') set.add("");
            else set.add("" + s.charAt(i));
        } else {
            if (s.charAt(i) == ')') set.addAll(dfs(f, i + 1, j, s));
            else if (s.charAt(j) == '(') set.addAll(dfs(f, i, j - 1, s));
            else {
                if (match(s.charAt(i), s.charAt(j)) && f[i][j] == f[i + 1][j - 1]) {
                    for (String ss : dfs(f, i + 1, j - 1, s))
                        set.add(String.format("%c%s%c", s.charAt(i), ss, s.charAt(j)));
                }
                for (int k = i; k < j; k++)
                    if (f[i][j] == f[i][k] + f[k + 1][j]) {
                        for (String left : dfs(f, i, k, s))
                            for (String right : dfs(f, k + 1, j, s))
                                set.add(left + right);
                    }
            }
        }
        memo[i][j] = set;
        return set;
    }

    private boolean match(char a, char b) {
        return (a == '(' && b == ')') || (a != '(' && a != ')' && b != '(' && b != ')');
    }

    public List<String> removeInvalidParentheses(String s) {
        if (s.equals("")) return Arrays.asList(s);

        int n = s.length();
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '(' || s.charAt(i) == ')') f[i][i] = 1;
        for (int delta = 1; delta < n; delta++)
            for (int i = 0; i < n - delta; i++) {
                int j = i + delta;
                if (s.charAt(i) == ')') f[i][j] = f[i + 1][j] + 1;
                else if (s.charAt(j) == '(') f[i][j] = f[i][j - 1] + 1;
                else {
                    f[i][j] = Integer.MAX_VALUE;
                    if (match(s.charAt(i), s.charAt(j)))
                        f[i][j] = Math.min(f[i][j], f[i + 1][j - 1]);
                    for (int k = i; k < j; k++)
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j]);
                }
            }
        memo = new Set[n + 1][n + 1];
        return new ArrayList<>(dfs(f, 0, n - 1, s));
    }
}

