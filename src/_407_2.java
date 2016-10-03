import java.util.*;

/**
 * LeetCode 407 - Trapping Rain Water II
 * <p>
 * SPFA - 99ms
 * https://discuss.leetcode.com/topic/60387/alternative-approach-using-dijkstra-in-o-rc-max-log-r-log-c-time
 */
public class _407_2 {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    List<int[]>[] g;
    int start;

    private int[] spfa() {
        int[] dist = new int[g.length];
        boolean[] inQueue = new boolean[g.length];
        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        inQueue[start] = true;
        dist[start] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            inQueue[u] = false;
            for (int[] edge : g[u]) {
                int v = edge[0], w = edge[1];
                if (Math.max(dist[u], w) < dist[v]) {
                    dist[v] = Math.max(dist[u], w);
                    if (!inQueue[v]) {
                        inQueue[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
        return dist;
    }

    public int trapRainWater(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) return 0;
        int r = a.length, c = a[0].length;

        start = r * c;
        g = new List[r * c + 1];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (i == 0 || i == r - 1 || j == 0 || j == c - 1) g[start].add(new int[]{i * c + j, 0});
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (x >= 0 && x < r && y >= 0 && y < c) g[i * c + j].add(new int[]{x * c + y, a[i][j]});
                }
            }

        int ans = 0;
        int[] dist = spfa();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                int cb = dist[i * c + j];
                if (cb > a[i][j]) ans += cb - a[i][j];
            }

        return ans;
    }
}