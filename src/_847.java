import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * LeetCode 847 - Shortest Path Visiting All Nodes
 * <p>
 * Hamiltonian-path solved by SPFA-style DP
 */
public class _847 {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int inf = 1 << 29;
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, inf);
        }

        int ans = inf;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] inQueue = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 0;
            queue.add(new int[]{i, 1 << i});
            inQueue[i][1 << i] = true;
        }

        while (!queue.isEmpty()) {
            int u = queue.peek()[0], mask = queue.peek()[1];
            queue.poll();
            inQueue[u][mask] = false;
            if (mask == (1 << n) - 1) {
                ans = Math.min(ans, dp[u][mask]);
            }

            for (int v : graph[u]) {
                int newMask = mask | (1 << v);
                if (dp[u][mask] + 1 < dp[v][newMask]) {
                    dp[v][newMask] = dp[u][mask] + 1;
                    if (!inQueue[v][newMask]) {
                        inQueue[v][newMask] = true;
                        queue.add(new int[]{v, newMask});
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _847 sol = new _847();


        System.out.println(sol.shortestPathLength(new int[][]{
                {1, 2, 3},
                {0},
                {0},
                {0},
        }));
        System.out.println(sol.shortestPathLength(new int[][]{
                {1},
                {0, 2, 4},
                {1, 3, 4},
                {2},
                {1, 2},
        }));
        System.out.println(sol.shortestPathLength(new int[][]{
                {},
        }));
        System.out.println(sol.shortestPathLength(new int[][]{
                {0},
        }));
    }
}

