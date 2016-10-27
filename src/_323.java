import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 323 - Number of Connected Components in an Undirected Graph
 * <p>
 * DFS
 */
public class _323 {

    private void dfs(int u, List<List<Integer>> adjList, boolean[] visited) {
        visited[u] = true;
        for (int v : adjList.get(u))
            if (!visited[v]) dfs(v, adjList, visited);
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (!visited[i]) {
                cnt++;
                dfs(i, adjList, visited);
            }
        return cnt;
    }
}