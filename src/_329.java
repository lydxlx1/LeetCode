/**
 * LeetCode 329 - Longest Increasing Path in a Matrix
 *
 * O(nm) DP
 *
 * A critical observation that the length of the longest increasing path must be finite,
 * i.e., the path cannot be a cycle. This observation encourages us to design a concise DP solution.
 *
 * Let dp[i][j] indicate the maximum length of all possible increasing path starting from position (i, j).
 * Then we have the following recurrence.
 *     dp[i][j] = 1, if matrix[i][j]is greater than any of its neighbors.
 *     dp[i][j] = 1 + max(dp[x][y]), where (x, y) is any direct neighbor of (i, j) satisfying matrix[i][j] < matrix[x][y].
 *     This simply means that we try to move one step forward, and among at most four possible longest subpaths,
 *     we choose the longest one.
 *
 * The final answer is max(dp[i][j]). This DP approach clearly requires both O(nm) time and space, where n and m are the two dimensions of the given matrix.
 *
 * Remark. The code above is a top-down implementation. One can also implement it in a bottom-up manner.
 * However, unlike many common DP problems, it requires a topological sort to determine the correct order to compute,
 * i.e., when we try to compute dp[i][j], all the dp[x][y]'s must be computed already.
 * The topological sort can be done by a simple BFS or DFS (though we can already solve this problem by a DFS/BFS).
 * Alternatively, one can achieve a correct topological order by simply sorting all the indices (i, j) in non-increasing
 * order where (i1, j1) < (i2, j2) if and only if matrix[i1][j1] < matrix[i2][j2].
 * This idea is in some sense cute but costs an additional log(nm) factor due to sorting.
 */
public class _329 {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] f;

    int dp(int[][] a, int i, int j) {
        if (f[i][j] > 0) return f[i][j]; // f[i][j] has been computed already.
        f[i][j] = 1; // also works for base cases.
        for (int k=0; k<4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[i][j] < a[x][y])
                f[i][j] = Math.max(f[i][j], 1 + dp(a, x, y));
        }
        return f[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        f = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i=0; i<matrix.length; i++)
            for (int j=0; j<matrix[0].length; j++)
                ans = Math.max(ans, dp(matrix, i, j));
        return ans;
    }
}