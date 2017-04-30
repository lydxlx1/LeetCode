/**
 * LeetCode 566 - Reshape the Matrix
 * <p>
 * Brute-force
 */
public class _566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c)
            return nums;

        int[][] res = new int[r][c];
        int ptr = 0;
        for (int[] row : nums)
            for (int num : row) {
                res[ptr / c][ptr % c] = num;
                ptr++;
            }

        return res;

    }
}