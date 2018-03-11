/**
 * LeetCode 799 - Champagne Tower
 */
public class _799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        int n = 100;
        double[][] f = new double[n + 1][n + 1];

        f[0][0] = poured;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] > 1) {
                    double more = f[i][j] - 1;
                    f[i][j] = 1;
                    f[i + 1][j] += 0.5 * more;
                    f[i + 1][j + 1] += 0.5 * more;
                }
            }
        }
        return f[query_row][query_glass];
    }
}
