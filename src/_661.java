/**
 * LeetCode 661 - Image Smoother
 */
class _661 {
    public int[][] imageSmoother(int[][] M) {
        int r = M.length, c = M[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int cnt = 0, sum = 0;

                for (int ii = i - 1; ii <= i + 1; ii++) {
                    for (int jj = j - 1; jj <= j + 1; jj++) {
                        if (ii >= 0 && ii < r && jj >= 0 && jj < c) {
                            cnt++;
                            sum += M[ii][jj];
                        }
                    }
                }
                res[i][j] = sum / cnt;
            }
        }
        return res;
    }
}