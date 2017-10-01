/**
 * LeetCode 688 - Knight Probability in Chessboard
 * <p>
 * DP
 */
class _688 {
    private final int DX[] = {1, 1, -1, -1, 2, 2, -2, -2};
    private final int DY[] = {2, -2, 2, -2, 1, -1, 1, -1};

    public double knightProbability(int N, int K, int r, int c) {
        double[][] cur = new double[N][N];
        cur[r][c] = 1;

        while (K-- > 0) {
            double[][] pre = cur;
            cur = new double[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    for (int k = 0; k < 8; k++) {
                        int x = i + DX[k];
                        int y = j + DY[k];
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            cur[x][y] += pre[i][j] / 8;
                        }
                    }
        }

        double ans = 0;
        for (double[] row : cur)
            for (double prob : row)
                ans += prob;
        return ans;
    }

    public static void main(String[] args) {
        _688 sol = new _688();
        System.out.println(sol.knightProbability(3, 2, 0, 0));
    }
}
