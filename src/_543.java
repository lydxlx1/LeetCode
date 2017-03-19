/**
 * LeetCode 543 - Diameter of Binary Tree
 *
 * DP-like approach
 */
public class _543 {

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        maxHeight(root);
        return diameter;
    }

    private int maxHeight(TreeNode root) {
        if (root == null) return -1;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);
        return height;
    }

    public static void main(String[] args) {
        _543 sol = new _543();
    }
}
