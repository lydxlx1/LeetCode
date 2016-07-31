/**
 * LeetCode 298 - Binary Tree Longest Consecutive Sequence
 *
 * A in-place DFS solution
 */
public class _298_1 {
    int ans;
    private void dfs(TreeNode root, int len) {
        ans = Math.max(ans, len);
        for (TreeNode child : new TreeNode[]{root.left, root.right})
            if (child != null) {
                if (root.val + 1 == child.val) dfs(child, len + 1);
                else dfs(child, 1);
            }
    }

    public int longestConsecutive(TreeNode root) {
        ans = 0;
        if (root != null) dfs(root, 1);
        return ans;
    }
}
