import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 515 - Find Largest Value in Each Tree Row
 * <p>
 * DFS approach
 */
public class _515 {

    public int[] findValueMostElement(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list.stream().mapToInt(u -> u).toArray();
    }

    private void dfs(TreeNode root, int d, List<Integer> list) {
        if (root == null) return;
        if (d >= list.size()) list.add(root.val);
        else list.set(d, Math.max(list.get(d), root.val));
        dfs(root.left, d + 1, list);
        dfs(root.right, d + 1, list);
    }
}


