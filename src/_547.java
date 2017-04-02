import java.util.function.Supplier;

/**
 * LeetCode 547 - Friend Circles
 * <p>
 * The answer is equal to the number of connected components in a undirected graph.
 */
public class _547 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) return 0;
        boolean[] visited = new boolean[M.length];
        return new Supplier<Integer>() {
            int cnt = 0;

            private void dfs(int i) {
                visited[i] = true;
                for (int j = 0; j < M.length; j++)
                    if (!visited[j] && M[i][j] == 1) dfs(j);
            }

            @Override
            public Integer get() {
                for (int i = 0; i < M.length; i++)
                    if (!visited[i]) {
                        cnt++;
                        dfs(i);
                    }
                return cnt;
            }
        }.get();
    }
}
