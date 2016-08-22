import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 386 - Lexicographical Numbers
 * <p>
 * Recursive Solution
 */
public class _386_1 {

    List<Integer> ans;

    private void dfs(int current, int n) {
        if (current > n) return;
        ans.add(current);
        for (int i = 0; i <= 9; i++) dfs(current * 10 + i, n);
    }

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>(n);
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return ans;
    }
}