import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 778 - Swim in Rising Water
 * <p>
 * Dijkstra
 */
public class _778_1 {

    public int swimInWater(int[][] grid) {
        final int[] dx = {0, 0, 1, -1};
        final int[] dy = {1, -1, 0, 0};

        int n = grid.length;
        final int max = Integer.MAX_VALUE / 2;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], max);
        }
        dist[0][0] = grid[0][0];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> dist[pair[0]][pair[1]]));
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int i = queue.peek()[0], j = queue.poll()[1];

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    int d = Math.max(dist[i][j], grid[x][y]);
                    if (d < dist[x][y]) {
                        dist[x][y] = d;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return dist[n - 1][n - 1];
    }

    public static void main(String[] args) {
        _778_1 sol = new _778_1();
    }
}
