import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 366 - Find Leaves of Binary Tree
 * <p>
 * Computing Tree Height
 */
public class _366 {
    List<List<Integer>> ans;

    private int dfs(TreeNode root) {
        if (root == null) return -1;
        int height = Math.max(dfs(root.left), dfs(root.right)) + 1;
        if (ans.size() < height + 1) ans.add(new ArrayList<>());
        ans.get(height).add(root.val);
        return height;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
}