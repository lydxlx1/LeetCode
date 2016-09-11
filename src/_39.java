import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 39 - Combination Sum
 *
 * DP + Backtracking
 */
public class _39 {

    private void dfs(boolean[][] f, int i, int j, int[] cands, List<List<Integer>> ans, List<Integer> current) {
        if (i == f.length - 1) {
            if (j == 0) ans.add(new ArrayList<>(current));
        } else {
            if (f[i + 1][j]) dfs(f, i + 1, j, cands, ans, current);
            if (j >= cands[i] && f[i][j - cands[i]]) {
                current.add(cands[i]);
                dfs(f, i, j - cands[i], cands, ans, current);
                current.remove(current.size() - 1); // O(1)
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        boolean[][] f = new boolean[candidates.length + 1][target + 1];
        f[candidates.length][0] = true;
        for (int i = candidates.length - 1; i >= 0; i--) {
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i + 1][j];
                if (j >= candidates[i]) f[i][j] = f[i][j] || f[i][j - candidates[i]];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(f, 0, target, candidates, ans, new ArrayList<>());
        return ans;
    }
}