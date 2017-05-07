/**
 * LeetCode 572 - Subtree of Another Tree
 * <p>
 * Brute-force O(n^2) runtime
 */
public class _572 {
    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null)
            return b == null;
        if (b == null)
            return a == null;
        return a.val == b.val && isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (isSame(s, t))
            return true;
        if (s.left != null && isSubtree(s.left, t))
            return true;
        if (s.right != null && isSubtree(s.right, t))
            return true;
        return false;
    }
}
