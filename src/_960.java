/**
 * LeetCode 960 - Delete Columns to Make Sorted III
 *
 * DP
 * This is essentially an extension of the famous Longest Increasing Subsequence problem.
 */
public class _960 {

    public int minDeletionSize(String[] A) {
        int M = A[0].length();
        int N = A.length;

        // Shift the index to make the strings in 1-index.
        for (int i = 0; i < N; i++) {
            A[i] = " " + A[i];
        }

        int[] f = new int[M + 1];
        // f[i] = Minimum # of columns to remove in order to make A[][1..i] valid, where the i-th column MUST be presented.
        for (int i = 1; i <= M; i++) {
            // At least, one feasible solution is simply remove the first (i-1) columns.
            f[i] = i - 1;

            for (int j = 1; j < i; j++) {
                boolean ok = true;
                for (int k = 0; k < N; k++) {
                    if (A[k].charAt(j) > A[k].charAt(i)) {
                        ok = false;
                    }
                }
                if (ok) {
                    f[i] = Math.min(f[i], f[j] + i - j - 1);
                }
            }
        }

        int ans = M - 1;
        for (int i = M; i >= 1; i--) {
            // Assume in the optimal solution, the i-th column is the last active column, which means we need to remove
            // all columns to the right of i.
            ans = Math.min(ans, f[i] + M - i);
        }

        return ans;
    }
}

