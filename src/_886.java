import java.util.*;
import java.util.stream.LongStream;

/**
 * Reachable Nodes in Subdivided Graph
 * <p>
 * Shortest Path + Greedy
 * Note that, when n = 0 for (i, j, n), we are NOT removing the edge (i, j).
 */
public class _886 {

    public int reachableNodes(int[][] edges, int M, int N) {
        List<int[]>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList[u].add(edge);
            adjList[v].add(edge);
        }

        // Dijkstra
        long[] dist = new long[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingLong(u -> dist[u]));
        queue.add(0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] edge : adjList[u]) {
                int v = edge[0] + edge[1] - u;
                int w = edge[2] + 1;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    queue.add(v);
                }
            }
        }

        long ans = LongStream.of(dist).map(d -> d <= M ? 1 : 0).sum();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            long a = Math.max(M - dist[u], 0);
            long b = Math.max(M - dist[v], 0);
            ans += Math.min(a + b, edge[2]);
        }
        return (int) ans;
    }
}

