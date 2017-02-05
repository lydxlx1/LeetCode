/**
 * LeetCode 498 - Diagonal Traversal
 * <p>
 * Direct Approach
 */
public class _498_1 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int r = matrix.length, c = matrix[0].length, ptr = 0;
        int[] res = new int[r * c];
        for (int d = 0; d < r + c - 1; d++) {
            // i + j = d
            // 0 <= i <= d
            // 0 <= i < r
            // 0 <= j < c
            // d - c < i <= d
            if (d % 2 == 0)
                for (int i = Math.min(d, r - 1); i >= 0 && i > d - c; i--) res[ptr++] = matrix[i][d - i];
            else
                for (int i = Math.max(0, d - c + 1); i <= d && i < r; i++) res[ptr++] = matrix[i][d - i];
        }
        return res;
    }
}

