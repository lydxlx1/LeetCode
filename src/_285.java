/**
 * LeetCode 285 - Inorder Successor in BST
 *
 * Top-down approach
 */
public class _285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while (root != null) {
            if (root.val > p.val) {
                ans = root;
                root = root.left;
            } else root = root.right;
        }
        return ans;
    }
}