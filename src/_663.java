/**
 * LeetCode 663 - Equal Tree Partition
 * <p>
 * DFS Solution without using any HashMap's
 * <p>
 * Here, since the values can be negative, the following codes can be dangerous:
 * 1) if (sum % 2 == 1) return false; // sum can be negative
 * 2) if (Math.abs(sum) % 2 == 1) return false; // abs(sum) can overflow
 * <p>
 * So, it is safer to write
 * 1) if (sum % 2 != 0) return false; or
 * 2) if (sum % 2 == 1 || sum % 2 == -1) return false.
 * <p>
 * In addition, a statement like (subtreeSum == sum / 2) is even more stupid.
 */


class _663 {
    private boolean isok = false;
    private int sum = 0;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        sum += root.val;
        dfs(root.left);
        dfs(root.right);
    }

    private int dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs1(root.left);
        int right = dfs1(root.right);
        if (root.left != null && left == sum - left) {
            isok = true;
        }
        if (root.right != null && right == sum - right) {
            isok = true;
        }
        return root.val + left + right;
    }

    public boolean checkEqualTree(TreeNode root) {
        dfs(root);
        dfs1(root);
        return isok;
    }
}