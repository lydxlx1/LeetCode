import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 254 - Factor Combinations
 */
public class _254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        class Helper {
            public void dfs(int n, List<Integer> factors) {
                if (factors.size() > 0) {
                    factors.add(n);
                    ans.add(new ArrayList<>(factors));
                    factors.remove(factors.size() - 1);
                }

                int start = factors.isEmpty() ? 2 : factors.get(factors.size() - 1);
                for (int i = start; i * i <= n; i++)
                    if (n % i == 0) {
                        factors.add(i);
                        dfs(n / i, factors);
                        factors.remove(factors.size() - 1);
                    }
            }
        }
        new Helper().dfs(n, new ArrayList<>());
        return ans;
    }
}