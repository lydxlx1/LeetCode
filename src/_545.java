import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 545 - Boundary of Binary Tree
 * <p>
 * Tree Traversal
 * Be careful to the following corner cases:
 * 1) The root does not have a left child.
 * 2) The root does not have a right child.
 * 3) The root is a leaf.
 * 4) The root is null.
 * <p>
 * Other than that, one just needs to avoid double counting.
 * There are many way to achieve that:
 * 1) use a HashSet;
 * 2) exclude the leaves on the left and right boundaries;
 * 3) etc.
 */
public class _545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            if (notLeaf(root)) res.add(root.val);
            if (root.left != null) leftBoundary(root.left, res);
            leaves(root, res);
            if (root.right != null) rightBoundary(root.right, res);
        }
        return res;
    }

    private boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return root.left == null && root.right == null;
    }

    private boolean notLeaf(TreeNode root) {
        if (root == null) return false;
        return !isLeaf(root);
    }

    private void leftBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (notLeaf(root)) list.add(root.val);
        if (root.left != null) leftBoundary(root.left, list);
        else leftBoundary(root.right, list);
    }

    private void leaves(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (isLeaf(root)) list.add(root.val);
        leaves(root.left, list);
        leaves(root.right, list);
    }

    private void rightBoundary(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.right != null) rightBoundary(root.right, list);
        else rightBoundary(root.left, list);
        if (notLeaf(root)) list.add(root.val);
    }
}
