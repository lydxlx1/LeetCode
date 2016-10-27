/**
 * LeetCode 298 - Binary Tree Longest Consecutive Sequence
 * <p>
 * Yet another DFS solution
 */
public class _298_2 {

    int ans = 0;

    private void dfs(TreeNode root, TreeNode parent, int size) {
        if (root == null) return;
        int newSize = parent == null || root.val - 1 == parent.val ? size + 1 : 1;
        ans = Math.max(ans, newSize);
        dfs(root.left, root, newSize);
        dfs(root.right, root, newSize);
    }

    public int longestConsecutive(TreeNode root) {
        ans = 0;
        dfs(root, null, 0);
        return ans;
    }
}