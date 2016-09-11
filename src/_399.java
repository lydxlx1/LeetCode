import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 399 - Evaluate Division
 * <p>
 * First apply Floyd Algorithm to compute the complete graph.
 * Then each query can be answered in O(1) time.
 */
public class _399 {

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

        // Floyd Algorithm
        Set<String> nodes = new HashSet<>(g.keySet());
        for (String k : nodes)
            for (String i : nodes)
                for (String j : nodes)
                    if (g.containsKey(i) && g.get(i).containsKey(k) && g.containsKey(k) && g.get(k).containsKey(j) && !g.get(i).containsKey(j))
                        g.get(i).put(j, g.get(i).get(k) * g.get(k).get(j));

        double[] ans = new double[query.length];
        for (int i = 0; i < ans.length; i++) {
            String u = query[i][0], v = query[i][1];
            if (g.containsKey(u) && g.get(u).containsKey(v)) ans[i] = g.get(u).get(v);
            else ans[i] = -1;
        }
        return ans;
    }
}