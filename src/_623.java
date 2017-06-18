/**
 * LeetCode 623 - Add One Row to Tree
 * <p>
 * DFS approach
 */
public class _623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode newRoot = new TreeNode(-1);
        newRoot.left = root;
        dfs(newRoot, v, d);
        return newRoot.left;
    }

    private void dfs(TreeNode root, int v, int d) {
        if (root == null)
            return;
        if (d == 1) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        } else {
            dfs(root.left, v, d - 1);
            dfs(root.right, v, d - 1);
        }
    }
}
