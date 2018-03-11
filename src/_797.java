import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 797 - All Paths from Source to Target
 * <p>
 * Backtracking
 */
public class _797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        dfs(0, graph, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private void dfs(int u, int[][] g, List<Integer> curPath, List<List<Integer>> allPaths) {
        curPath.add(u);

        if (u == g.length - 1) {
            allPaths.add(new ArrayList<>(curPath));
        } else {
            for (int v : g[u]) {
                dfs(v, g, curPath, allPaths);
            }
        }
        curPath.remove(curPath.size() - 1);
    }
}
