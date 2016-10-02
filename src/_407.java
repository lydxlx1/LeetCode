import java.util.PriorityQueue;

/**
 * LeetCode 407 - Trapping Rain Water II
 * <p>
 * Use a priority queue to maintain the out-most contour of the map.
 * At each time, pop out the lowest bar from the queue and consider its unvisited neighbors.
 * <p>
 * The queue will store at most O(n + m) elements, results in an O((n + m) log (n + m)) algorithm.
 */
public class _407 {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int water = 0, r = heightMap.length, c = heightMap[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((u, v) -> Integer.compare(heightMap[u[0]][u[1]], heightMap[v[0]][v[1]]));
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            push(i, 0, heightMap, queue, visited);
            push(i, c - 1, heightMap, queue, visited);
        }
        for (int j = 0; j < c; j++) {
            push(0, j, heightMap, queue, visited);
            push(r - 1, j, heightMap, queue, visited);
        }
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int i = queue.peek()[0], j = queue.poll()[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && x < r && y >= 0 && y < c && !visited[x][y]) {
                    water += Math.max(0, heightMap[i][j] - heightMap[x][y]);
                    heightMap[x][y] = Math.max(heightMap[x][y], heightMap[i][j]);
                    push(x, y, heightMap, queue, visited);
                }
            }
        }
        return water;
    }

    private void push(int i, int j, int[][] map, PriorityQueue<int[]> queue, boolean[][] visited) {
        if (!visited[i][j]) {
            visited[i][j] = true;
            queue.add(new int[]{i, j});
        }
    }
}