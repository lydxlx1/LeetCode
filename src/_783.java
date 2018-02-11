/**
 * LeetCode 783 - Minimum Distance Between BST Nodes
 * <p>
 * In-order traversal
 */
public class _783 {

    Integer previous = null;
    int ans = 0;

    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        previous = null;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (previous != null) {
            ans = Math.min(ans, root.val - previous);
        }
        previous = root.val;
        dfs(root.right);
    }
}
