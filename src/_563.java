/**
 * LeetCode 563 - Binary Tree Tilt
 * <p>
 * DFS approach
 */
public class _563 {
    int ans;

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
}
