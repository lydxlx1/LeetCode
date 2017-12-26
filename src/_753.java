import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 753 - Cracking the Safe
 * <p>
 * Eulerian Circuit
 * <p>
 * 1. Try our best to let two consecutive words share the most (i.e., n - 1) letters.
 * 2. Treat all the k^(n-1) strings as nodes, and each node has k outgoing edges.
 * 3. The beauty here is that each n-letter word (except the first one) is now mapped to each edge.
 * 4. Then, exhausting all n-letter words is equivalent as finding the Eulerian Circuit.
 * 5. The generated directed graph is highly symmetric, i.e., # of in-degree = # of out-degree holds true for every node, so the Eulerian Circuit exists.
 */
public class _753 {

    public String crackSafe(int n, int k) {

        Set<String> visited = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        class EulerianCircuit {
            private void dfs(String s) {
                for (int i = 0; i < k; i++) {
                    String edge = s + i;
                    String node = edge.substring(1);
                    if (!visited.contains(edge)) {
                        visited.add(edge);
                        dfs(node);
                        builder.append(i);
                    }
                }
            }
        }

        String start = "";
        for (int i = 0; i < n - 1; i++)
            start += 0;

        if (k == 1) {
            builder.append(0);
        } else {
            (new EulerianCircuit()).dfs(start);
        }
        return builder.append(start).reverse().toString();
    }
}

