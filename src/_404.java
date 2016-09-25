/**
 * LeetCode 404 - Sum of Left Leaves
 * <p>
 * Simple DFS approach.
 * Note: A single node is NOT considered as a left leaf.
 */
public class _404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if (root != null) {
            ans += sumOfLeftLeaves(root.left);
            ans += sumOfLeftLeaves(root.right);
            if (root.left != null && root.left.left == null && root.left.right == null) ans += root.left.val;
        }
        return ans;
    }
}