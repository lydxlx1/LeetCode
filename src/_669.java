/**
 * LeetCode 669 - Trim a Binary Search Tree
 * <p>
 * DFS approach
 */
class _669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        if (L <= root.val && root.val <= R) {
            root.left = left;
            root.right = right;
            return root;
        } else {
            // Since root.val is already out of range, at least one of left or right must be null.
            return left != null ? left : right;
        }
    }
}