import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 924 - Minimize Malware Spread
 *
 * A very good DFS problem
 */
public class _924 {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        boolean[] visited = new boolean[graph.length];
        List<int[]> candidate = new ArrayList<>();
        Set<Integer> initialAsSet = IntStream.of(initial).boxed().collect(Collectors.toSet());

        candidate.add(new int[]{0, IntStream.of(initial).min().getAsInt()});
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                List<Integer> cluster = new ArrayList<>();
                dfs(i, graph, visited, cluster);

                List<Integer> intersection = new ArrayList<>(cluster);
                intersection.retainAll(initialAsSet);

                if (intersection.size() == 1) {
                    candidate.add(new int[]{cluster.size(), intersection.get(0)});
                }
            }
        }
        // Maximize cluster size first, then prefer smaller index.
        return candidate.stream().min(Comparator.<int[]>comparingInt(p -> p[0]).reversed().thenComparing(p -> p[1])).get()[1];
    }

    void dfs(int u, int[][] graph, boolean[] visited, List<Integer> cluster) {
        visited[u] = true;
        cluster.add(u);
        for (int v = 0; v < graph.length; v++) {
            if (!visited[v] && graph[u][v] == 1) {
                dfs(v, graph, visited, cluster);
            }
        }
    }
}

