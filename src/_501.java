import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 501 - Find Mode in Binary Tree
 * <p>
 * DFS + HashMap
 */
public class _501 {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int maxFrequency = 0;
        for (int frequency : map.values()) maxFrequency = Math.max(maxFrequency, frequency);
        List<Integer> modes = new ArrayList<>();
        for (int key : map.keySet()) if (map.get(key) == maxFrequency) modes.add(key);
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }
}

