import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 508 - Most Frequent Subtree Sum
 * <p>
 * Tree traversal
 */
public class _508 {

    Map<Integer, Integer> map = new HashMap<>();
    int maxF = 0;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = dfs(root.left) + dfs(root.right) + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxF = Math.max(maxF, map.get(sum));
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        dfs(root);
        return map.keySet().stream().filter(s -> map.get(s) == maxF).mapToInt(i -> i).toArray();
    }
}
