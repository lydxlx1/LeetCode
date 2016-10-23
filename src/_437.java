import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 437 - Path Sum III
 *
 * One-pass DFS
 */
public class _437 {

    int ans = 0;

    Map<Integer, Integer> dfs(TreeNode root, int sum) {
        if (root == null) return new HashMap<>();
        Map<Integer, Integer> left = dfs(root.left, sum);
        Map<Integer, Integer> right = dfs(root.right, sum);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(root.val, 1);
        for (Map.Entry<Integer, Integer> entry : left.entrySet()) {
            int cb = entry.getKey() + root.val;
            int wb = entry.getValue();
            map.putIfAbsent(cb, 0);
            map.put(cb, map.get(cb) + wb);
        }
        for (Map.Entry<Integer, Integer> entry : right.entrySet()) {
            int cb = entry.getKey() + root.val;
            int wb = entry.getValue();
            map.putIfAbsent(cb, 0);
            map.put(cb, map.get(cb) + wb);
        }
        ans += map.getOrDefault(sum, 0);
        return map;
    }

    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        dfs(root, sum);
        return ans;
    }
}
