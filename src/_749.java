/**
 * LeetCode 749 - Contain Virus
 * <p>
 * A very good implementation problem
 */
public class _749 {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int r, c, currentColor = 0, bar = 0, uninfected = 0;

    class Cell {
        boolean containVirus;
        boolean blocked;
        int dfsColor;
        int uninfectedColor;

        public Cell(boolean containVirus) {
            this.containVirus = containVirus;
        }
    }

    private void dfs(Cell[][] g, int i, int j) {
        g[i][j].dfsColor = currentColor;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < r && y >= 0 && y < c && !g[x][y].blocked) {
                if (g[x][y].containVirus) {
                    if (g[x][y].dfsColor != currentColor)
                        dfs(g, x, y);
                } else {
                    bar++;
                    if (g[x][y].uninfectedColor != currentColor) {
                        uninfected++;
                        g[x][y].uninfectedColor = currentColor;
                    }
                }
            }
        }
    }

    private int doit(Cell[][] g) {
        int colorThreshold = currentColor, maxUninfected = 0, colorUnderMaxUninfected = 0;
        int ans = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (g[i][j].containVirus && !g[i][j].blocked && g[i][j].dfsColor <= colorThreshold) {
                    bar = uninfected = 0;
                    currentColor++;
                    dfs(g, i, j);

                    if (uninfected > maxUninfected) {
                        maxUninfected = uninfected;
                        ans = bar;
                        colorUnderMaxUninfected = currentColor;
                    }
                }
        if (maxUninfected > 0) {
            // First, block the max region
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    if (g[i][j].dfsColor == colorUnderMaxUninfected)
                        g[i][j].blocked = true;

            // Second, expand the remaining viruses.
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    if (!g[i][j].blocked && g[i][j].dfsColor > colorThreshold) {
                        assert (g[i][j].containVirus);
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k], y = j + dy[k];
                            if (x >= 0 && x < r && y >= 0 && y < c && !g[x][y].blocked)
                                g[x][y].containVirus = true;
                        }
                    }
            ans += doit(g);
        }
        return ans;
    }

    public int containVirus(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        Cell[][] g = new Cell[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                g[i][j] = new Cell(grid[i][j] == 1);
        return doit(g);
    }
}

