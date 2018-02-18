import java.util.stream.IntStream;

/**
 * LeetCode 785 - Is Graph Bipartite?
 * <p>
 * Black-white coloring by DFS
 */
public class _785 {

    public boolean isBipartite(int[][] graph) {
        int[] color = IntStream.range(0, graph.length).map(i -> -1).toArray();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1 && !dfs(i, 0, graph, color)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int u, int c, int[][] g, int[] color) {
        color[u] = c;
        for (int v : g[u]) {
            if (color[v] == -1) {
                if (!dfs(v, 1 - c, g, color)) {
                    return false;
                }
            } else {
                if (color[v] != 1 - color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
