import java.util.*;
import java.util.stream.IntStream;


/**
 * Shortest Path with Alternating Colors
 *
 * SSSP
 * Need to encode both node index and color information as state when doing SSSP.
 */
public class ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int inf = 1 << 28, RED = 0, BLUE = 1;
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][RED] = dist[i][BLUE] = inf;
        }
        List<Integer>[][] edges = new ArrayList[n][2];
        for (int i = 0; i < n; i++) {
            edges[i][RED] = new ArrayList<>();
            edges[i][BLUE] = new ArrayList<>();
        }
        for (int[] edge : red_edges) {
            edges[edge[0]][RED].add(edge[1]);
        }
        for (int[] edge : blue_edges) {
            edges[edge[0]][BLUE].add(edge[1]);
        }

        // state = [node index, color of the outgoing edge]
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(arr -> dist[arr[0]][arr[1]]));
        // Both colors are fine for the initial point 0.
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        dist[0][0] = dist[0][1] = 0;
        while (!queue.isEmpty()) {
            int u = queue.peek()[0];
            int color = queue.poll()[1];

            for (int v : edges[u][color]) {
                if (dist[u][color] + 1 < dist[v][1 - color]) {
                    dist[v][1 - color] = dist[u][color] + 1;
                    queue.add(new int[]{v, 1 - color});
                }
            }
        }
        return IntStream.range(0, n).map(i -> Math.min(dist[i][0], dist[i][1])).map(i -> i >= inf ? -1 : i).toArray();
    }
}


