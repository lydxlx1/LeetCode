import java.util.*;
import java.util.stream.IntStream;

/**
 * LeetCode 685 - Redundant Connection II
 *
 * Single-DFS approach
 *
 * Consider the following three cases:
 * 1. The extra edge forms a cycle that contains the original root.
 *    Since the root has 0 in-degree, therefore, no node with in-degree=2 will be generated.
 *    In this case, every edge along the cycle is safe to delete, and we should remove the one that appears later in
 *    the given list.
 * 2. The extra edge forms a cycle that does not contains the original root.
 *    In this case, there must exist a node with in-degree=2. Among the two incoming edges, the one that create the
 *    cycle must be removed.
 *
 *    Here is an interesting example, where A is the original tree node.
 *    If we do a dfs starting form C, a cycle will be detected, but note that the back-edge (B->C) is NOT the bad edge.
 *    We should focus on vertex B, which has in-degree=2, and consider the two in-coming edges (C -> B and A -> B).
 *    Here, the edge C -> B contributes in creating the cycle, and therefore, it must be removed.
 *
 *    A -> B -> C
 *         ^    |
 *         |    v
 *         * <- *
 *
 *  3. No cycle is created. That means, the extra edge points from some vertex A to some other vertex B, where
 *     A and B have a LCA that is not equal to neither A nor B.
 *     This means, vertex B now has in-degree = 2, and it is safe to remove either of the two incoming edges.
 *     So, we naturally prefer the one that appears later.
 */
public class _685 {

    int n;
    int[][] edges;
    List<Integer>[] in, out;
    boolean[] visited;

    private int dfs(int u, int d, Map<Integer, Integer> ancestors, Set<Integer> ancestorEdges) {
        visited[u] = true;
        ancestors.put(u, d);

        for (int i : out[u]) {
            int v = edges[i][1];
            ancestorEdges.add(i);

            if (!visited[v]) {
                int ret = dfs(v, d + 1, ancestors, ancestorEdges);
                if (ret != -1) return ret;
            } else if (!ancestors.containsKey(v)) {
                if (in[v].size() == 2) return Math.max(in[v].get(0), in[v].get(1));
            } else {
                for (int j : ancestors.keySet())
                    if (in[j].size() == 2) {
                        int x = edges[in[j].get(0)][0], y = edges[in[j].get(1)][0];
                        return ancestors.getOrDefault(x, -1) > ancestors.getOrDefault(y, -1) ? in[j].get(0) : in[j].get(1);
                    }
                return ancestorEdges.stream().max(Integer::compareTo).get();
            }

            ancestorEdges.remove(i);
        }
        ancestors.remove(u);
        return -1;
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        n = 0;
        this.edges = edges;
        for (int[] edge : edges)
            n = Math.max(n, IntStream.of(edge).max().getAsInt());
        in = new List[n + 1];
        out = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            out[edges[i][0]].add(i);
            in[edges[i][1]].add(i);
        }

        for (int i = 1; i <= n; i++)
            if (!visited[i]) {
                int ans = dfs(i, 0, new HashMap<>(), new HashSet<>());
                if (ans != -1) return edges[ans];
            }

        throw new RuntimeException("Should not reach here...");
    }
}

