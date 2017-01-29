/**
 * LeetCode 499 - The Maze II
 * <p>
 * DFS approach
 */
public class _499_1 {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private char[] dir = "rldu".toCharArray();

    private int[][] dist; // shortest distance from the ball
    private String[][] path; // best sequence according to the shortest distance

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        dist = new int[maze.length][maze[0].length];
        path = new String[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                path[i][j] = "";
            }
        dfs(ball[0], ball[1], 0, "", maze, hole);
        return dist[hole[0]][hole[1]] == Integer.MAX_VALUE ? "impossible" : path[hole[0]][hole[1]];
    }

    private void dfs(int i, int j, int d, String s, int[][] maze, int[] hole) {
        if (d > dist[i][j] || (d == dist[i][j] && s.compareTo(path[i][j]) >= 0)) return;
        dist[i][j] = d;
        path[i][j] = s;

        for (int k = 0; k < dx.length; k++) {
            int x = i, y = j;
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += dx[k];
                y += dy[k];
                if (x - dx[k] == hole[0] && y - dy[k] == hole[1]) break; // Stop if we just passed the hole
            }
            x -= dx[k];
            y -= dy[k];
            dfs(x, y, d + Math.abs(i - x) + Math.abs(j - y), s + dir[k], maze, hole);
        }
    }
}

