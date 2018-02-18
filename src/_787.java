import java.util.stream.IntStream;

/**
 * LeetCode 787 - Cheapest Flights Within K Stops
 * <p>
 * DP
 */
public class _787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final int inf = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = inf;
            }
        }
        for (int[] flight : flights) {
            int u = flight[0], v = flight[1], w = flight[2];
            g[u][v] = Math.min(g[u][v], w);
        }

        int[] d = IntStream.range(0, n).map(i -> inf).toArray();
        d[src] = 0;

        K++;
        while (K-- > 0) {
            int[] dd = d.clone();

            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    dd[v] = Math.min(dd[v], d[u] + g[u][v]);
                }
            }

            d = dd;
        }

        return d[dst] < inf ? d[dst] : -1;

    }
}
