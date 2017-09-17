/**
 * LeetCode 678 - Valid Parenthesis String
 * <p>
 * O(n^3)-time DP
 */
class _678 {
    String s;
    int n;
    Boolean[][] f;

    private boolean f(int i, int j) {
        if (i == j) {
            return s.charAt(i) == '*';
        } else if (i > j) {
            return true;
        } else if (f[i][j] != null) {
            return f[i][j];
        } else {
            boolean res = false;

            if (s.charAt(i) == '*') {
                res = res || f(i + 1, j);
            }
            if (s.charAt(j) == '*') {
                res = res || f(i, j - 1);
            }
            if ((s.charAt(i) == '(' || s.charAt(i) == '*') && (s.charAt(j) == ')' || s.charAt(j) == '*')) {
                res = res || f(i + 1, j - 1);
            }

            for (int k = i; k < j; k++) {
                res = res || (f(i, k) && f(k + 1, j));
            }

            f[i][j] = res;
            return res;
        }
    }

    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        this.s = s;
        n = s.length();
        f = new Boolean[n][n];
        return f(0, n - 1);
    }
}