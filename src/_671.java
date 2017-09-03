import java.util.Optional;

/**
 * LeetCode 671 - Second Minimum Node In a Binary Tree
 * <p>
 * DFS approach
 */
class _671 {
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val).orElse(-1);
    }

    private Optional<Integer> dfs(TreeNode root, int min) {
        if (root == null) {
            return Optional.empty();
        }

        if (root.val == min) {
            Optional<Integer> left = dfs(root.left, min);
            Optional<Integer> right = dfs(root.right, min);
            if (!left.isPresent()) {
                return right;
            } else if (!right.isPresent()) {
                return left;
            } else {
                return Optional.of(Math.min(left.get(), right.get()));
            }
        } else {
            return Optional.of(root.val);
        }
    }
}