import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 890 - Possible Bipartition
 * <p>
 * DFS
 */
public class _886 {

    int[] color;
    List<Integer>[] g;

    private boolean dfs(int u) {
        for (int v : g[u]) {
            if (color[v] != 0) {
                if (color[u] == color[v]) {
                    return false;
                }
            } else {
                color[v] = -color[u];
                if (!dfs(v)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        color = new int[N + 1];
        g = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            int u = dislike[0], v = dislike[1];
            g[u].add(v);
            g[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                if (!dfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}