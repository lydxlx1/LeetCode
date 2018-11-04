import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * LeetCode 934 - Shortest Bridge
 *
 * DFS + BFS
 */
public class _934 {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    boolean[][] islandOne;
    int r, c;

    int[][] dist;
    Queue<int[]> queue;

    public int shortestBridge(int[][] A) {
        r = A.length;
        c = A[0].length;
        islandOne = new boolean[r][c];
        dist = new int[r][c];
        queue = new ArrayDeque<>();
        int inf = 1 << 29;
        for (int[] arr : dist) {
            Arrays.fill(arr, inf);
        }

        findFirstIsland:
        {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (A[i][j] == 1) {
                        dfs(A, i, j, islandOne);
                        break findFirstIsland;
                    }
                }
            }
        }

        // Now, do a bfs to find the shortest bridge.
        while (!queue.isEmpty()) {
            int i = queue.peek()[0];
            int j = queue.poll()[1];

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < r && y >= 0 && y < c && dist[x][y] == inf) {
                    dist[x][y] = dist[i][j] + 1;
                    queue.add(new int[]{x, y});
                    if (!islandOne[x][y] && A[x][y] == 1) {
                        // This implies the existence of the second island.
                        return dist[x][y] - 1;
                    }

                }
            }
        }

        throw new RuntimeException("");
    }

    private void dfs(int[][] A, int i, int j, boolean[][] islandOne) {
        islandOne[i][j] = true;
        dist[i][j] = 0;
        queue.add(new int[]{i, j});

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < r && y >= 0 && y < c && A[x][y] == 1 && !islandOne[x][y]) {
                dfs(A, x, y, islandOne);
            }
        }

    }
}

