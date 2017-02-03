import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 505 - The Maze II
 * <p>
 * A* Search
 */
public class _505_1 {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private boolean isok(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        class State {
            final int x, y;
            final int d, h; // h is A* heuristic

            // Assert that d < dist[x][y]
            private State(int x, int y, int d) {
                this.x = x;
                this.y = y;
                this.d = d;
                dist[x][y] = d;
                h = d + Math.abs(destination[0] - x) + Math.abs(destination[1] - y);
            }
        }

        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparing(u -> u.h)); // A*
        queue.add(new State(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            State s = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = s.x + dx[k], y = s.y + dy[k], cnt = 1;
                while (isok(maze, x, y)) {
                    x += dx[k];
                    y += dy[k];
                    cnt++;
                }
                x -= dx[k];
                y -= dy[k];
                int d = s.d + cnt - 1;
                if (d < dist[x][y]) queue.add(new State(x, y, d));
            }
        }

        int res = dist[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;

    }
}
