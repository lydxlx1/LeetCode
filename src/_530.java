/**
 * LeetCode 530 - Minimum Absolute Difference in BST
 * <p>
 * DFS approach
 */
public class _530 {

    long previous;
    long minDiff;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        minDiff = Math.min(minDiff, root.val - previous);
        previous = root.val;
        dfs(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        previous = Integer.MIN_VALUE;
        minDiff = Integer.MAX_VALUE;
        dfs(root);
        return (int) minDiff;
    }
}
