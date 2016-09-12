/**
 * LeetCode 333 - Largest BST Subtree
 *
 * Tree-DP
 */
public class _333 {

    static class Info {
        int cnt = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean is = true;
    }

    private int ans = 0;

    private Info dfs(TreeNode root) {
        if (root == null) return new Info();
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        Info current = new Info();
        if (current.is = left.is && right.is && root.val >= left.max && root.val <= right.min) {
            current.cnt = left.cnt + right.cnt + 1;
            current.min = Math.min(root.val, left.min);
            current.max = Math.max(root.val, right.max);
            ans = Math.max(ans, current.cnt);
        }
        return current;
    }

    public int largestBSTSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
}