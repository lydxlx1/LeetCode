/**
 * LeetCode 298 - Binary Tree Longest Consecutive Sequence
 *
 * Tree-DP
 * f[i][0]: length of the longest sequence in the subtree rooted at i that starts from root.
 * f[i][1]: length of the longest sequence in the subtree rooted at i
 *
 * f[i][] can be computed in a DFS fashion.
 */
public class _298 {
    private int[] dfs(TreeNode root) {
        int[] f = {1, 1};
        for (TreeNode child : new TreeNode[]{root.left, root.right})
            if (child != null) {
                int[] g = dfs(child);
                if (root.val + 1 == child.val) f[0] = Math.max(f[0], 1 + g[0]);
                f[1] = Math.max(f[1], g[1]);
            }
        f[1] = Math.max(f[0], f[1]);
        return f;
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        else return dfs(root)[1];
    }
}
