import java.util.Arrays;

/**
 * LeetCode 505 - The Maze II
 * <p>
 * DFS + Pruning
 * Relatively slow...
 */
public class _505 {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private boolean isok(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dfs(maze, dist, start[0], start[1], 0);
        int res = dist[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    public void dfs(int[][] maze, int[][] dist, int x, int y, int d) {
        if (d >= dist[x][y]) return;
        dist[x][y] = d;

        for (int k = 0; k < dx.length; k++) {
            int xx = x + dx[k], yy = y + dy[k], cnt = 1;
            while (isok(maze, xx, yy)) {
                xx += dx[k];
                yy += dy[k];
                cnt++;
            }
            xx -= dx[k];
            yy -= dy[k];
            dfs(maze, dist, xx, yy, d + cnt - 1);
        }
    }
}
