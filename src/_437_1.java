import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 437 - Path Sum III
 * <p>
 * Another version of one-pass DFS
 */
public class _437_1 {
    int ans = 0;
    int sum = 0;

    void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int key : map.keySet()) map1.put(key + root.val, map.get(key));
        map1.putIfAbsent(root.val, 0);
        map1.put(root.val, map1.get(root.val) + 1);
        ans += map1.getOrDefault(sum, 0);

        dfs(root.left, map1);
        dfs(root.right, map1);
    }

    public int pathSum(TreeNode root, int sum) {
        this.ans = 0;
        this.sum = sum;
        dfs(root, new HashMap<>());
        return ans;
    }
}
