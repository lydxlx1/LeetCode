/**
 * LeetCode 979 - Distribute Coins in Binary Tree
 *
 * Top-down Approach
 */
public class _979_1 {

    int ans = 0;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        ans += Math.abs(left[0] - left[1]);
        ans += Math.abs(right[0] - right[1]);

        return new int[]{left[0] + right[0] + 1, left[1] + right[1] + root.val};
    }
}

