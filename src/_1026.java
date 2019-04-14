/**
 * LeetCode 1026 - Maximum Difference Between Node and Ancestor
 *
 * DFS
 * Basically we only need carry the max/min number from the current node up to the root.
 */
public class _1026 {

    int ans;

    public int maxAncestorDiff(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return ans;
    }

    void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, Math.abs(root.val - min));
        ans = Math.max(ans, Math.abs(root.val - max));
        dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
