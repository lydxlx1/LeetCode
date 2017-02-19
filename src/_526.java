/**
 * LeetCode 526 - Beautiful Arrangement
 * <p>
 * Permutation Generator
 */
public class _526 {

    private int dfs(int t, int N, boolean[] visited) {
        if (t > N) return 1;
        int ans = 0;
        for (int i = 1; i <= N; i++)
            if (!visited[i] && (i % t == 0 || t % i == 0)) {
                visited[i] = true;
                ans += dfs(t + 1, N, visited);
                visited[i] = false;
            }
        return ans;
    }

    public int countArrangement(int N) {
        return dfs(1, N, new boolean[20]);
    }
}


