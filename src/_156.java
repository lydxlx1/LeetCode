/**
 * LeetCode 156 - Binary Tree Upside Down
 * <p>
 * This problem can be used via a single post-order traversal.
 * But honestly speaking, I don't like the problem statement at all...
 */
public class _156 {
    TreeNode r, newRoot;

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        dfs(root.left, root);
        dfs(root.right, root);
        if (r == null) {
            r = new TreeNode(root.val);
            newRoot = r;
        } else if (parent != null && parent.right == root) r.left = new TreeNode(root.val);
        else {
            r.right = new TreeNode(root.val);
            r = r.right;
        }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        r = newRoot = null;
        dfs(root, null);
        return newRoot;
    }
}