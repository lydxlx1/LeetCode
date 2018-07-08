import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * LeetCode 865 - Shortest Path to Get All Keys
 * <p>
 * SPFA
 */
public class _865 {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int shortestPathAllKeys(String[] grid) {
        int r = grid.length, c = grid[0].length();
        char[][] g = new char[r][];
        for (int i = 0; i < r; i++) {
            g[i] = grid[i].toCharArray();
        }


        final int INF = Integer.MAX_VALUE / 2;
        int[][][] dist = new int[r][c][1 << 6];
        boolean[][][] inQueue = new boolean[r][c][1 << 6];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                Arrays.fill(dist[i][j], INF);

        int ans = INF;
        int numKeys = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                char ch = g[i][j];
                if (ch == '@') {
                    dist[i][j][0] = 0;
                    inQueue[i][j][0] = true;
                    queue.add(new int[]{i, j, 0});
                } else if (Character.isLowerCase(ch)) {
                    numKeys = Math.max(numKeys, ch - 'a' + 1);
                }
            }

        while (!queue.isEmpty()) {
            int x = queue.peek()[0], y = queue.peek()[1], keysInHand = queue.poll()[2];
//            System.out.println(x + " " + y + " " + keysInHand + " " + dist[x][y][keysInHand]);
            inQueue[x][y][keysInHand] = false;
            for (int k = 0; k < 4; k++) {
                int xx = x + dx[k], yy = y + dy[k];
                if (xx >= 0 && xx < r && yy >= 0 && yy < c) {
                    char ch = g[xx][yy];
                    if (ch == '@' || ch == '.' || Character.isLowerCase(ch) || (Character.isUpperCase(ch) && ((1 << (ch - 'A')) & keysInHand) != 0)) {
                        int newKeysInHand = Character.isLowerCase(ch) ? keysInHand | (1 << (ch - 'a')) : keysInHand;
                        if (dist[x][y][keysInHand] + 1 < dist[xx][yy][newKeysInHand]) {
                            dist[xx][yy][newKeysInHand] = dist[x][y][keysInHand] + 1;
                            if (!inQueue[xx][yy][newKeysInHand]) {
                                inQueue[xx][yy][newKeysInHand] = true;
                                queue.add(new int[]{xx, yy, newKeysInHand});
                            }

                            if (newKeysInHand == (1 << numKeys) - 1) {
                                ans = Math.min(ans, dist[xx][yy][newKeysInHand]);
                            }
                        }
                    }
                }
            }
        }

        return ans < INF ? ans : -1;
    }
}

