/**
 * LeetCode 889 - Spiral Matrix III
 * <p>
 * Solution
 */
public class _885 {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int cnt = 0;
        int i = r0, j = c0;
        int k = 0;
        int len = 1;

        ans[cnt] = new int[]{i, j};
        cnt++;
        while (cnt < R * C) {
            for (int doit = 0; doit < 2; doit++) {
                for (int t = 0; t < len; t++) {
                    i += dx[k];
                    j += dy[k];
                    if (i >= 0 && i < R && j >= 0 && j < C) {
                        ans[cnt] = new int[]{i, j};
                        cnt++;
                    }
                }
                k = (k + 1) % 4;
            }
            len++;
        }
        return ans;
    }
}

