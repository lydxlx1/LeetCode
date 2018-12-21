/**
 * LeetCode 959 - Regions Cut by Slashes
 *
 * We can scale-up a cell to a 3x3 one. That is:
 *
 * "/" -> "  /",
 *        " / ",
 *        "/  ",
 *
 * "\" -> "\  ",
 *     -> " \ ",
 *     -> "  \",
 *
 * " " -> "   ",
 *     -> "   ",
 *     -> "   ".
 *
 * After that, we can just run a standard dfs to compute the # of connected components in the scaled matrix.
 *
 * Quite similar to the idea of "anti-aliasing" or Apple's "retina display", huh?
 */
public class _959 {

    int n;
    boolean[][] isBlock;
    boolean[][] visited;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int regionsBySlashes(String[] grid) {
        n = 3 * grid.length;
        isBlock = new boolean[n][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char ch = grid[i].charAt(j);
                if (ch == '/') {
                    isBlock[3 * i][3 * j + 2] = isBlock[3 * i + 1][3 * j + 1] = isBlock[3 * i + 2][3 * j] = true;
                } else if (ch == '\\') {
                    isBlock[3 * i][3 * j] = isBlock[3 * i + 1][3 * j + 1] = isBlock[3 * i + 2][3 * j + 2] = true;
                }
            }
        }

        visited = new boolean[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && !isBlock[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && !isBlock[x][y]) {
                dfs(x, y);
            }
        }
    }
}
