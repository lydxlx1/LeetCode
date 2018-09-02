/**
 * LeetCode 897 - Increasing Order Search Tree
 *
 * In-order Traversal
 */
public class _897 {

    TreeNode head;
    TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        pre = null;
        head = null;
        dfs(root);
        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        root.left = null; // No longer needs this pointer as the entire left-subtree has been visited.

        head = head != null ? head : root;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;

        dfs(root.right);
    }
}

