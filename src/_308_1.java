/**
 * LeetCode - Range Sum Query 2D - Mutable
 *
 * 2D Fenwick Tree
 *
 * O(log^2 n) per operation
 */
public class _308_1 {
    int[][] matrix;
    int[][] bit;

    private void add(int x, int y, int value) {
        // Be careful, it is bit.length here, not matrix.length
        for (int i = x; i < bit.length; i += Integer.lowestOneBit(i))
            for (int j = y; j < bit[i].length; j += Integer.lowestOneBit(j))
                bit[i][j] += value;
    }

    private int sum(int x, int y) {
        int ans = 0;
        for (int i = x; i > 0; i -= Integer.lowestOneBit(i))
            for (int j = y; j > 0; j -= Integer.lowestOneBit(j))
                ans += bit[i][j];
        return ans;
    }

    public _308_1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        this.matrix = matrix;
        bit = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                add(i + 1, j + 1, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        if (this.matrix == null) return;
        add(row + 1, col + 1, val - matrix[row][col]);
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.matrix == null) return 0;
        return sum(row2 + 1, col2 + 1) - sum(row2 + 1, col1) - sum(row1, col2 + 1) + sum(row1, col1);
    }
}