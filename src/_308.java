/**
 * LeetCode - 308 Range Sum Query 2D - Mutable
 * <p>
 * 2D sqrt-partition trick
 * <p>
 * Assume the given matrix is n by n, i.e., total input size is O(n^2).
 * We partition each dimension into sqrt(n) blocks, hence
 * there will be sqrt(n) * sqrt(n) 2D blocks in total.
 * <p>
 * +-------+-------+-------+-------+-------+-------+-------+...
 * |       |       |       |       |       |       |       |
 * |       |       |       |       |       |       |       |
 * |       |       |       |       |       |       |       |
 * +-------+-------+-------+-------+-------+-------+-------+...
 * |       |       |       |       |       |       |       |
 * |       |   *---|-------|-------|-------|---*   |       |
 * |       |   |   |       |       |       |   |   |       |
 * +-------+---+---+-------+-------+-------+---+---+-------+...
 * |       |   |   |       |       |       |   |   |       |
 * |       |   |   |       |       |       |   |   |       |
 * |       |   |   |       |       |       |   |   |       |
 * +-------+---+---+-------+-------+-------+---+---+-------+...
 * |       |   |   |       |       |       |   |   |       |
 * |       |   *---|-------|-------|-------|---*   |       |
 * |       |       |       |       |       |       |       |
 * +-------+-------+-------+-------+-------+-------+-------+...
 * .
 * .
 * .
 * <p>
 * The query region can contain at most sqrt(n) * sqrt(n) whole blocks, which takes O(n) time to compute their sum.
 *
 * The partial part consists of (at most) four corners and four edges.
 * Each corner contains at most sqrt(n) * sqrt(n) numbers, so brute-force on the four corners takes O(n) time.
 * Each edge consists of at moat sqrt(n) * sqrt(n) horizontal or vertical 1D segments of length sqrt(n),
 * thus costing O(n) time. Note that, this is essentially the 1D range query.
 *
 * We maintain n 2D-block sum, which takes O(n) space.
 * We also maintain 2n 1D-block sum (n horizontal and n vertical), which takes O(n * sqrt(n)) = O(n^1.5) space.
 *
 * To this end, each query can be answered in O(n) time, and each update can be done in O(1) time.
 *
 */
public class _308 {
    int[][] sum;
    int[][] sumRow;
    int[][] sumCol;
    int[][] matrix;
    int R, C;

    public _308(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        this.matrix = matrix;
        R = (int) Math.sqrt(matrix.length) + 1;
        C = (int) Math.sqrt(matrix[0].length) + 1;
        sum = new int[R][C];
        sumRow = new int[matrix.length][C];
        sumCol = new int[R][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                sum[i / R][j / C] += matrix[i][j];
                sumRow[i][j / C] += matrix[i][j];
                sumCol[i / R][j] += matrix[i][j];
            }
    }

    public void update(int row, int col, int val) {
        if (this.matrix == null) return;
        sum[row / R][col / C] += val - matrix[row][col];
        sumRow[row][col / C] += val - matrix[row][col];
        sumCol[row / R][col] += val - matrix[row][col];
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.matrix == null) return 0;

        int ans = 0;
        row2++; // [row1, row2)
        col2++; // [col1, col2)
        while (row1 < row2 && row1 % R != 0) {
            int c1 = col1, c2 = col2;
            while (c1 < c2 && c1 % C != 0) ans += matrix[row1][c1++];
            while (c1 < c2 && c2 % C != 0) ans += matrix[row1][--c2];
            for (int j = c1 / C; j < c2 / C; j++) ans += sumRow[row1][j];
            row1++;
        }
        while (row1 < row2 && row2 % R != 0) {
            int c1 = col1, c2 = col2;
            while (c1 < c2 && c1 % C != 0) ans += matrix[row2 - 1][c1++];
            while (c1 < c2 && c2 % C != 0) ans += matrix[row2 - 1][--c2];
            for (int j = c1 / C; j < c2 / C; j++) ans += sumRow[row2 - 1][j];
            row2--;
        }

        // Now, row1 % R == row2 % R == 0
        while (col1 < col2 && col1 % C != 0) {
            for (int i = row1 / R; i < row2 / R; i++) ans += sumCol[i][col1];
            col1++;
        }
        while (col1 < col2 && col2 % C != 0) {
            for (int i = row1 / R; i < row2 / R; i++) ans += sumCol[i][col2 - 1];
            col2--;
        }

        // Now, col1 % C == col2 % C == 0
        for (int i = row1 / R; i < row2 / R; i++)
            for (int j = col1 / C; j < col2 / C; j++)
                ans += sum[i][j];

        return ans;
    }
}
