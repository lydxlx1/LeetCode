/**
 * LeetCode 943 - Find the Shortest Superstring
 *
 * DP
 * This is problem is solvable by DP due to the non-containing property.
 */
public class _943 {

    int n;
    String[][] f;
    String[] A;
    int[][] maxOverlap;

    public String shortestSuperstring(String[] A) {
        n = A.length;
        f = new String[1 << n][n];
        this.A = A;

        maxOverlap = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                String left = A[i];
                String right = A[j];

                for (int k = Math.min(left.length(), right.length()); k > 0; k--) {
                    if (left.substring(left.length() - k).equals(right.substring(0, k))) {
                        maxOverlap[i][j] = k;
                        break;
                    }
                }
            }
        String ans = null;
        int mask = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            if (ans == null || f(mask, i).length() < ans.length()) {
                ans = f(mask, i);
            }
        }
        return ans;
    }

    String f(int mask, int last) {
        if (f[mask][last] != null) {
            return f[mask][last];
        }
        if (Integer.bitCount(mask) == 1) {
            return A[last];
        }

        String ans = null;
        int subMask = mask - (1 << last);
        for (int i = 0; i < n; i++) {
            if (((1 << i) & subMask) != 0) {
                String subAns = f(subMask, i);
                String curAns = subAns + A[last].substring(maxOverlap[i][last]);
                if (ans == null || curAns.length() < ans.length()) {
                    ans = curAns;
                }
            }
        }

        f[mask][last] = ans;
        return ans;
    }
}

