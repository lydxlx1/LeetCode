import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 40 - Combination Sum II
 * <p>
 * DP Knapsack
 * For this problem, it is interesting to think how to dedup without using Set/HashSet.
 */
public class _40 {
    private void dfs(boolean[][] f, int i, int j, int[] cand, List<Integer> current, List<List<Integer>> ans) {
        if (i == f.length - 1) ans.add(new ArrayList<>(current));
        else {
            // For the items with same weight, we fix a unique selection pattern
            // NO, NO, ..., NO, YES, YES, ... YES
            if ((current.isEmpty() || current.get(current.size() - 1) != cand[i]) && f[i + 1][j]) // dedup
                dfs(f, i + 1, j, cand, current, ans);
            if (j >= cand[i] && f[i + 1][j - cand[i]]) {
                current.add(cand[i]);
                dfs(f, i + 1, j - cand[i], cand, current, ans);
                current.remove(current.size() - 1); // O(1)
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[][] f = new boolean[candidates.length + 1][target + 1];
        Arrays.sort(candidates); // used for dedup
        f[candidates.length][0] = true;
        for (int i = candidates.length - 1; i >= 0; i--)
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i + 1][j];
                if (j >= candidates[i]) f[i][j] = f[i][j] || f[i + 1][j - candidates[i]];
            }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(f, 0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }
}