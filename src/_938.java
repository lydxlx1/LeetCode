/**
 * LeetCode 938 - Range Sum of BST
 *
 * DFS
 */
public class _938 {

    int sum = 0;
    int L, R;

    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        this.L = L;
        this.R = R;
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return sum;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        if (max < L || min > R) {
            return;
        }
        if (L <= root.val && root.val <= R) {
            sum += root.val;
        }
        dfs(root.left, min, Math.min(max, root.val));
        dfs(root.right, Math.max(min, root.val), max);
    }
}

