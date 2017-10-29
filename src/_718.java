/**
 * LeetCode 718 - Maximum Length of Repeated Subarray
 * <p>
 * Simple O(AB)-time DP
 * The space complexity can be further optimized to O(min(A, B)), though.
 */
public class _718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ans = 0;

        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1])
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    f[i][j] = 0;
                ans = Math.max(ans, f[i][j]);
            }

        return ans;

    }
}
