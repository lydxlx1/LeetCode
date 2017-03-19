/**
 * LeetCode 538 - Convert BST to Greater Tree
 * <p>
 * Right-root-left-traversal
 */
public class _538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);

        int tmpVal = root.val;
        root.val += sum;
        sum += tmpVal;

        dfs(root.left);
    }

    public static void main(String[] args) {
        _538 sol = new _538();
    }
}
