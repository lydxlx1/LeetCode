import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 417 - Pacific Atlantic Water Flow
 * <p>
 * If water can only flow from one cell to its direct neighbor with strictly smaller height,
 * then this problem can also be solved by using DP.
 * However, it is not the case here since the we can move between equal-height cells.
 * Then the underlying graph is no longer acyclic.
 * <p>
 * A common trick to make the graph acyclic again is to contract each connected component (sharing the same height)
 * into one point. After the contraction, we can apply DP to solve the problem.
 * The code is of course tedious...
 */
public class _417_1 {

    Integer[] f;
    int r, c;
    int[][] a;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    int[][] color;
    int globalColor;
    List<Integer>[] g;
    List<Integer>[] group;

    int F(int u) {
        if (f[u] != null) return f[u];

        int mask = 0;
        for (int state : group[u]) {
            if (state % c == 0 || state / c == 0) mask |= 1;
            if (state % c == c - 1 || state / c == r - 1) mask |= 2;
        }
        for (int v : g[u]) mask |= F(v);
        f[u] = mask;
        return mask;
    }

    private void dfs(int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        color[i][j] = globalColor;
        group[globalColor].add(i * c + j);

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < r && y >= 0 && y < c && a[i][j] == a[x][y] && !visited[x][y]) {
                dfs(x, y, visited);
            }
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        r = matrix.length;
        c = matrix[0].length;
        this.a = matrix;

        boolean[][] visited = new boolean[r][c];
        List<int[]> ans = new ArrayList<>();

        color = new int[r][c];
        group = new List[r * c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (!visited[i][j]) {
                    group[globalColor] = new ArrayList<>();
                    dfs(i, j, visited);
                    globalColor++;
                }
        g = new List[globalColor];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < r && y >= 0 && y < c && a[i][j] > a[x][y]) {
                        g[color[i][j]].add(color[x][y]);
                    }
                }

        f = new Integer[globalColor];
        for (int i = 0; i < globalColor; i++)
            if (F(i) == 3)
                for (int state : group[i]) {
                    ans.add(new int[]{state / c, state % c});
                }

        return ans;
    }
}