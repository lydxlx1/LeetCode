/**
 * LeetCode 463 - Island Perimeter
 * <p>
 * Brute-force
 */
public class _463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int ans = 0, n = grid.length, m = grid[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    for (int k = 0; k < dx.length; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) ans++;
                    }
                }
        return ans;
    }
}