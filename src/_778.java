/**
 * LeetCode 778 - Swim in Rising Water
 * <p>
 * Binary Search + DFS
 */
public class _778 {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = -1, right = n * n - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[n][n];
            if (grid[0][0] <= mid) dfs(grid, mid, visited, 0, 0);
            if (visited[n - 1][n - 1]) right = mid;
            else left = mid;

        }
        return right;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    void dfs(int[][] a, int max, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] <= max && !visited[x][y]) {
                dfs(a, max, visited, x, y);
            }
        }
    }
}
