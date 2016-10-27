import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode 286 - Walls and Gates
 * <p>
 * BFS
 */
public class _286 {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[i].length; j++)
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int i = queue.peek()[0], j = queue.poll()[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[i][j] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}