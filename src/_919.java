/**
 * LeetCode 919 - Complete Binary Tree Inserter
 */
public class _919 {

    TreeNode[] nodes = new TreeNode[65535];
    int size = 0;

    public _919(TreeNode root) {
        dfs(root, 1);
    }

    void dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        size = Math.max(size, i);
        nodes[i] = root;
        dfs(root.left, 2 * i);
        dfs(root.right, 2 * i + 1);
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        size++;
        nodes[size] = node;

        TreeNode parent = nodes[size / 2];
        if (size / 2 * 2 == size) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return parent.val;
    }

    public TreeNode get_root() {
        return nodes[1];
    }
}
