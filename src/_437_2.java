/**
 * LeetCode 437 - Path Sum III
 * <p>
 * Two-dfs approach
 */
public class _437_2 {
    int ans = 0;

    private void dfs2(TreeNode root, int sum) {
        if (root == null) return;
        if (sum - root.val == 0) ans++;
        dfs2(root.left, sum - root.val);
        dfs2(root.right, sum - root.val);
    }

    private void dfs1(TreeNode root, int sum) {
        if (root == null) return;
        dfs2(root, sum);
        dfs1(root.left, sum);
        dfs1(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        dfs1(root, sum);
        return ans;
    }
}