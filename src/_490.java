import java.util.Arrays;

/**
 * LeetCode 490 - The Maze
 * <p>
 * DFS approach
 */
public class _490 {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private boolean isok(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && (maze[x][y] & 1) == 0;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (Arrays.equals(start, destination)) return true;
        int x = start[0], y = start[1];
        if ((maze[x][y] & 2) != 0) return false; // if visited then no solution
        maze[x][y] |= 2;

        for (int k = 0; k < dx.length; k++) {
            int xx = x + dx[k], yy = y + dy[k];
            while (isok(maze, xx, yy)) {
                xx += dx[k];
                yy += dy[k];
            }
            xx -= dx[k];
            yy -= dy[k];
            if ((xx != x || yy != y) && hasPath(maze, new int[]{xx, yy}, destination)) return true;
        }
        return false;
    }
}
