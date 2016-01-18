/**
 * LeetCode 304 - Range Sum Query 2D - Immutable
 *
 * Inclusion-Exclusion
 *
 * Let sum[i][j] be the sum of numbers in the rectangle whose top left corner is (0, 0), and bottom right corner is (i, j).
 * Then the query can be answered by using Inclusion-Exclusion principle.
 * In fact, initializing sum[][] also relies on Inclusion-Exclusion.
 */
public class _304 {

    int[][] sum;

    public _304(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) sum = new int[1][1];
        else sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++)
            for (int j = 1; j <= matrix[0].length; j++)
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
