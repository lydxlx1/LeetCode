/**
 * LeetCode 750 - Number of Corner Rectangles
 * <p>
 * Similar to max sub-rectangle sum
 */
public class _750 {
    public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = i + 1; j < grid.length; j++) {
                int cnt = 0;
                for (int k = 0; k < grid[i].length; k++)
                    if (grid[i][k] == 1 && grid[j][k] == 1)
                        cnt++;
                ans += cnt * (cnt - 1) / 2;
            }
        return ans;
    }
}

