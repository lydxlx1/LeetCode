import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 285 - Inorder Successor in BST
 * <p>
 * This solution assumes parent pointer is given for each node in the tree.
 */
public class _285_1 {
    private Map<TreeNode, TreeNode> map;

    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        map.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        map = new HashMap<>();
        dfs(root, null);

        if (p.right == null) {
            while (map.get(p) != null && map.get(p).right == p) p = map.get(p);
            return map.get(p);
        } else {
            for (p = p.right; p.left != null; p = p.left) ;
            return p;
        }
    }
}