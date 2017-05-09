/**
 * LeetCode 317 - Shortest Distance from All Buildings
 * <p>
 * BFS from each building in general
 * However, there is also a very elegant solution according to
 * https://discuss.leetcode.com/topic/31702/36-ms-c-solution.
 */
public class _317 {
    public int shortestDistance(int[][] grid) {
        final int[] dx = {0, 0, 1, -1};
        final int[] dy = {1, -1, 0, 0};
        int r = grid.length;
        int c = grid[0].length;
        int houseCovered = 0;
        int minTotalDist = -1;
        int[][] dist = new int[r][c];
        int[][] total = new int[r][c];
        int[][] queue = new int[r * c][2];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (grid[i][j] == 1) {
                    minTotalDist = -1;

                    int head = 0;
                    int tail = 1;
                    dist[i][j] = 0;
                    queue[0][0] = i;
                    queue[0][1] = j;
                    while (head < tail) {
                        int x = queue[head][0];
                        int y = queue[head][1];
                        head++;

                        for (int k = 0; k < 4; k++) {
                            int xx = x + dx[k];
                            int yy = y + dy[k];
                            if (xx >= 0 && xx < r && yy >= 0 && yy < c && grid[xx][yy] == -houseCovered) {
                                grid[xx][yy] = -houseCovered - 1;
                                dist[xx][yy] = dist[x][y] + 1;
                                total[xx][yy] += dist[xx][yy];
                                if (minTotalDist == -1 || total[xx][yy] < minTotalDist)
                                    minTotalDist = total[xx][yy];
                                queue[tail][0] = xx;
                                queue[tail][1] = yy;
                                tail++;
                            }
                        }
                    }
                    houseCovered++;
                }
        return minTotalDist;
    }
}
