import java.util.Arrays;

/**
 * LeetCode 505 - The Maze II
 * <p>
 * DFS + Multithreading
 */
public class _505_2 {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private static int[][] permutations = {
            {0, 1, 2, 3},
            {0, 1, 3, 2},
            {0, 2, 1, 3},
            {0, 2, 3, 1},
            {0, 3, 1, 2},
            {0, 3, 2, 1},
            {1, 0, 2, 3},
            {1, 0, 3, 2},
            {1, 2, 0, 3},
            {1, 2, 3, 0},
            {1, 3, 0, 2},
            {1, 3, 2, 0},
            {2, 0, 1, 3},
            {2, 0, 3, 1},
            {2, 1, 0, 3},
            {2, 1, 3, 0},
            {2, 3, 0, 1},
            {2, 3, 1, 0},
            {3, 0, 1, 2},
            {3, 0, 2, 1},
            {3, 1, 0, 2},
            {3, 1, 2, 0},
            {3, 2, 0, 1},
            {3, 2, 1, 0},
    };

    private boolean isok(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        Thread[] worker = new Thread[permutations.length];
        for (int i = 0; i < worker.length; i++) {
            final int id = i;
            worker[i] = new Thread(new Runnable() {

                public void dfs(int x, int y, int d) {
                    if (d >= dist[x][y]) return;
                    dist[x][y] = d; // sync problem will occur, but it will not affect the correctness.

                    for (int k : permutations[id]) {
                        int xx = x + dx[k], yy = y + dy[k], cnt = 1;
                        while (isok(maze, xx, yy)) {
                            xx += dx[k];
                            yy += dy[k];
                            cnt++;
                        }
                        xx -= dx[k];
                        yy -= dy[k];
                        dfs(xx, yy, d + cnt - 1);
                    }
                }

                @Override
                public void run() {
                    dfs(start[0], start[1], 0);
                }
            });
            worker[i].start();
        }

        for (int i = 0; i < worker.length; i++)
            try {
                worker[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        int res = dist[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}