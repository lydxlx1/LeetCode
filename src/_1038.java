/**
 * LeetCode 1038 - Binary Search Tree to Greater Sum Tree
 *
 * In-order traversal (right -> root -> left)
 */
public class _1038 {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
