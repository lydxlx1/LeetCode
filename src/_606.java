/**
 * LeetCode 606 - Construct String from Binary Tree
 * <p>
 * Pay attention to the definition of the miminal representation
 */
public class _606 {
    StringBuilder builder = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t != null)
            dfs(t);
        return builder.toString();
    }

    private void dfs(TreeNode t) {
        builder.append("" + t.val);
        if (t.left != null) {
            builder.append("(");
            dfs(t.left);
            builder.append(")");
        }
        if (t.right != null) {
            if (t.left == null)
                builder.append("()");
            builder.append("(");
            dfs(t.right);
            builder.append(")");
        }
    }
}