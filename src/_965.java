/**
 * LeetCode 965 - Univalued Binary Tree
 *
 * DFS
 */
public class _965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root, root.val);
    }

    boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        return root.val == val && dfs(root.left, val) && dfs(root.right, val);
    }
}

