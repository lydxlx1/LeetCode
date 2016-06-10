import java.util.stream.IntStream;

/**
 * LeetCode 354 - Russian Doll Envelopes
 *
 * O(n^2) DP
 * Longest Path in a DAG
 */
public class _354 {

    static int[] f;

    private int F(int u, int[][] g) {
        if (f[u] > 0) return f[u];
        f[u] = 1;
        for (int v = 0; v < g.length; v++)
            if (g[u][0] < g[v][0] && g[u][1] < g[v][1]) f[u] = Math.max(f[u], 1 + F(v, g));
        return f[u];
    }

    public int maxEnvelopes(int[][] g) {
        f = new int[g.length];
        return IntStream.range(0, g.length).map(i -> F(i, g)).max().orElse(0);
    }
}