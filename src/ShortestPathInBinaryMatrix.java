import java.util.ArrayDeque;
import java.util.Queue;


/**
 * Shortest Path in Binary Matrix
 *
 * BFS
 */
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {1, -1, -1, 0, 1, -1, 0, 1};

        boolean[][] visited = new boolean[r][c];

        visited[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>(); // [x, y, d] => location (x, y) with shortest distance d
        if (grid[0][0] == 0) {
            queue.add(new int[]{0, 0, 1});
            if (r == 1 && c == 1) {
                return 1;
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int d = queue.poll()[2];
            for (int i = 0; i < dx.length; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < r && yy >= 0 && yy < c && !visited[xx][yy] && grid[xx][yy] == 0) {
                    visited[xx][yy] = true;
                    queue.add(new int[]{xx, yy, d + 1});
                    if (xx == r - 1 && yy == c - 1) {
                        return d + 1;
                    }
                }
            }
        }
        return -1;
    }
}
