/**
 * LeetCode 450 - Delete Node in a BST
 *
 * Short implementation using a dummy parent of the root.
 */
public class _450_1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummyRoot = new TreeNode(0), x = root, p = dummyRoot;
        dummyRoot.left = root;

        while(x != null && x.val != key) {
            p = x;
            if (key < x.val) x = x.left;
            else x = x.right;
        }
        if (x != null && x.val == key) {
            if (x.left != null && x.right != null) {
                p = x;
                TreeNode y = x.right;
                for(; y.left != null; p = y, y = y.left); // empty for-body
                x.val = y.val;
                x = y; // Instead of deleting x, we delete y.
            }

            // Now, at least one child of x must be null.
            TreeNode child = x.left != null ? x.left : x.right;
            if (p.left == x) p.left = child;
            else p.right = child;
        }
        return dummyRoot.left;
    }
}
