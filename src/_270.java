/**
 * LeetCode 270 - Closest Binary Search Tree Value
 *
 * Path Traversal in BST
 */
public class _270 {
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        while (root != null) {
            if (Double.compare(Math.abs(target - root.val), Math.abs(target - ans)) < 0) ans = root.val;
            if (target < root.val) root = root.left;
            else root = root.right;
        }
        return ans;
    }
}