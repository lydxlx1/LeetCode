/**
 * LeetCode 807 - Max Increase to Keep City Skyline
 */
public class _807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] rowMax = new int[c];
        int[] colMax = new int[r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rowMax[j] = Math.max(rowMax[j], grid[i][j]);
                colMax[i] = Math.max(colMax[i], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans += Math.max(0, Math.min(rowMax[j], colMax[i]) - grid[i][j]);
            }
        }

        return ans;
    }
}
