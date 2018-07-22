/**
 * LeetCode 873 - Length of Longest Fibonacci Sequence
 * <p>
 * DP
 */
public class _873 {

    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int ans = 0;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            int k = 0;
            for (int j = i + 1; j < n; j++) {
                f[i][j] = 2;
                // The amortized runtime of this while-loop is O(1).
                while (k < i && A[k] + A[i] < A[j]) {
                    k++;
                }
                if (k < i && A[k] + A[i] == A[j]) {
                    f[i][j] = 1 + f[k][i];
                }
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans == 2 ? 0 : ans;
    }
}

