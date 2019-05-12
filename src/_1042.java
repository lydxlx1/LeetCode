import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 1042 - Flower Planting With No Adjacent
 *
 * Pigeonhole Principle
 *
 * Just need to under the following sentence correctly.
 * "Also, there is no garden that has more than 3 paths coming into or leaving it."
 * This means, total # of degree of any node is <= 3.
 */
public class _1042 {

    public int[] gardenNoAdj(int N, int[][] paths) {
        List<Integer>[] g = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            g[u].add(v);
            g[v].add(u);
        }

        int[] color = new int[N];
        for (int u = 1; u <= N; u++) {
            boolean[] visited = new boolean[5];
            for (int i : g[u]) {
                visited[color[i - 1]] = true;
            }
            for (int i = 1; i <= 4; i++) {
                if (!visited[i]) {
                    color[u - 1] = i;
                    break;
                }
            }
        }
        return color;
    }
}
