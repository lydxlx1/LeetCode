/**
 * LeetCode 250 - Count Univalue Subtrees
 * <p>
 * DFS
 */
public class _250 {
    int cnt = 0;

    private boolean dfs(TreeNode root) {
        if (root == null) return true;
        boolean left = dfs(root.left); // Here, we shall NOT combine this line to compound expression below due to unexpected short-circuiting
        boolean right = dfs(root.right); // Same here.
        boolean isUnival = left && right && (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val);
        if (isUnival) cnt++;
        return isUnival;
    }

    public int countUnivalSubtrees(TreeNode root) {
        cnt = 0;
        dfs(root);
        return cnt;
    }
}