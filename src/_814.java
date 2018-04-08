/**
 * LeetCode 814 - Binary Tree Pruning
 * <p>
 * DFS
 */
public class _814 {

    public TreeNode pruneTree(TreeNode root) {
        boolean rootContainsOne = containsOne(root);
        if (!rootContainsOne) {
            return null;
        } else {
            return root;
        }
    }

    private boolean containsOne(TreeNode root) {
        if (root == null) return false;

        boolean containsOne = root.val == 1;
        boolean leftContainsOne = containsOne(root.left);
        boolean rightContainsOne = containsOne(root.right);

        if (!leftContainsOne) {
            root.left = null;
        }
        if (!rightContainsOne) {
            root.right = null;
        }

        return containsOne || leftContainsOne || rightContainsOne;
    }
}
