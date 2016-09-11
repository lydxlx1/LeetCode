import java.util.*;

/**
 * LeetCode 399 - Evaluate Division
 * <p>
 * DFS for path finding
 */
public class _399_1 {

    // Need to be careful to handle the case when s == target.
    // We want make sure the path length is at least 2 in that case.
    private Optional<Double> dfs(String u, double value, String target, Map<String, Map<String, Double>> g, Set<String> visited) {
        visited.add(u);
        for (String v : g.getOrDefault(u, new HashMap<>()).keySet()) {
            if (v.equals(target)) return Optional.of(value * g.get(u).get(v));
            Optional<Double> tmp = null;
            if (!visited.contains(v) && (tmp = dfs(v, value * g.get(u).get(v), target, g, visited)).isPresent())
                return tmp;
        }
        return Optional.empty();
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String u = equations[i][0], v = equations[i][1];
            double w = values[i];

            g.putIfAbsent(u, new HashMap<>());
            g.get(u).put(v, w);
            g.putIfAbsent(v, new HashMap<>());
            g.get(v).put(u, 1.0 / w);
        }

        double[] ans = new double[query.length];
        for (int i = 0; i < ans.length; i++) {
            String u = query[i][0], v = query[i][1];
            ans[i] = dfs(u, 1.0, v, g, new HashSet<>()).orElse(-1.0);
        }
        return ans;
    }
}