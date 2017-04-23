/**
 * LeetCode 562 - Longest Line of Consecutive One in Matrix
 * <p>
 * Brute-force
 * O(RC) runtime
 */
public class _562 {
    private final int[] DX = {0, 1, 1, 1};
    private final int[] DY = {1, 0, 1, -1};

    private boolean isOne(int[][] M, int i, int j) {
        return i >= 0 && i < M.length && j >= 0 && j < M[i].length && M[i][j] == 1;
    }

    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[i].length; j++) {
                for (int k = 0; k < DX.length; k++) {
                    if (isOne(M, i, j) && !isOne(M, i - DX[k], j - DY[k])) {
                        int cnt = 0;
                        for (int x = i, y = j; isOne(M, x, y); cnt++, x += DX[k], y += DY[k]) ;
                        ans = Math.max(ans, cnt);
                    }
                }
            }
        return ans;
    }
}
