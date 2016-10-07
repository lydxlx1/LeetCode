import java.util.List;

/**
 * LeetCode 339 - Nested List Weight Sum
 * <p>
 * DFS
 */
public class _339 {
    private int dfs(int weight, NestedInteger nested) {
        if (nested.isInteger()) return weight * nested.getInteger();
        else {
            int sum = 0;
            for (NestedInteger i : nested.getList()) sum += dfs(weight + 1, i);
            return sum;
        }
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger nested : nestedList) sum += dfs(1, nested);
        return sum;
    }
}