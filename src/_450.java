/**
 * LeetCode 450 - Delete Node in a BST
 * <p>
 * Iterative Solution using O(h) time and O(1) space
 */
public class _450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode parent = null, x = root;
        while (x != null && x.val != key) {
            parent = x;
            if (key < x.val) x = x.left;
            else x = x.right;
        }
        if (x == null) return root; // key not found in the tree

        if (x.left != null && x.right != null) {
            // We can find either the predecessor or the successor.
            // In this case, let's find the successor.
            TreeNode y = x;
            parent = x;
            x = x.right;
            while (x.left != null) {
                parent = x;
                x = x.left;
            }

            int tmp = y.val;
            y.val = x.val;
            x.val = tmp;
        }

        assert x.left == null || x.right == null : "'At least one child is null' invariant violated.";

        TreeNode child = x.left != null ? x.left : x.right;
        if (x == root) {
            return child;
        } else {
            if (parent.left == x) parent.left = child;
            else parent.right = child;
            return root;
        }
    }
}