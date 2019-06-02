import java.util.LinkedList;
import java.util.Queue;


/**
 * LeetCode 1066 - Campus Bikes II
 *
 * Optimal Bipartite Graph Matching
 * My solution is min cost max flow. Alternatively, one can just apply KM algorithm.
 */
public class _1066 {

    /**
     * Assume source = 0, sink = n - 1. * Please new the class for each query
     */
    static class Graph {
        int n;
        int cost[][];
        int capacity[][];
        int dist[];
        int pre[];
        boolean visited[];
        int maxFlow;
        int totalCost;
        final int INF = Integer.MAX_VALUE >> 1; // Need to be careful here

        public Graph(int n) {
            this.n = n;
            cost = new int[n][n];
            capacity = new int[n][n];
        }

        public void add(int u, int v, int capacity, int cost) {
            this.capacity[u][v] += capacity;
            this.cost[u][v] += cost;
            this.cost[v][u] -= cost; // Do not forget!
        }

        private boolean SPFA() {
            Queue<Integer> q = new LinkedList<Integer>();
            dist = new int[n];
            visited = new boolean[n];
            pre = new int[n];

            q.add(0);
            for (int i = 0; i < n; i++)
                dist[i] = INF;
            dist[0] = 0;
            visited[0] = true;

            while (!q.isEmpty()) {
                int u = q.poll();
                visited[u] = false;
                for (int v = 0; v < n; v++)
                    if (capacity[u][v] > 0 && dist[u] + cost[u][v] < dist[v]) {
                        dist[v] = dist[u] + cost[u][v];
                        pre[v] = u;
                        if (!visited[v]) {
                            visited[v] = true;
                            q.add(v);
                        }
                    }
            }
            return dist[n - 1] < INF;
        }

        private void adjust() {
            int flow = Integer.MAX_VALUE;
            for (int i = n - 1; i != pre[i]; i = pre[i])
                flow = Math.min(flow, capacity[pre[i]][i]);
            for (int i = n - 1; i != pre[i]; i = pre[i]) {
                capacity[pre[i]][i] -= flow;
                capacity[i][pre[i]] += flow;
                totalCost += flow * cost[pre[i]][i];
            }
            maxFlow += flow;
        }

        public int minCostMaxFlow() {
            while (SPFA()) adjust();
            return totalCost;
        }
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        // Start to assign labels
        int N = 0;
        int source = N++;
        int[] workerLabel = new int[workers.length];
        int[] bikeLabel = new int[bikes.length];
        for (int i = 0; i < workerLabel.length; i++) {
            workerLabel[i] = N++;
        }
        for (int i = 0; i < bikeLabel.length; i++) {
            bikeLabel[i] = N++;
        }
        int sink = N++;

        // Build the graph
        Graph g = new Graph(N);
        for (int i = 0; i < workerLabel.length; i++) {
            g.add(source, workerLabel[i], 1, 0);
        }
        for (int i = 0; i < workerLabel.length; i++) {
            for (int j = 0; j < bikeLabel.length; j++) {
                int cost = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                g.add(workerLabel[i], bikeLabel[j], 1, cost);
            }
        }
        for (int i = 0; i < bikeLabel.length; i++) {
            g.add(bikeLabel[i], sink, 1, 0);
        }

        // Compute!
        return g.minCostMaxFlow();
    }
}
