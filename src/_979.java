import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode 979 - Distribute Coins in Binary Tree
 *
 * Buttom-up Approach
 */
public class _979 {

    Map<TreeNode, TreeNode> parent;
    Map<TreeNode, Integer> degree;
    Queue<TreeNode> queue;

    public int distributeCoins(TreeNode root) {
        int ans = 0;
        parent = new HashMap<>();
        degree = new HashMap<>();
        queue = new ArrayDeque<>();
        dfs(root, null);
        while (!queue.isEmpty()) {
            TreeNode leaf = queue.poll();
            ans += Math.abs(1 - leaf.val);
            if (leaf != root) {
                TreeNode p = parent.get(leaf);
                p.val += leaf.val - 1;
                degree.put(p, degree.get(p) - 1);
                if (degree.get(p) == 0) {
                    queue.add(p);
                }
            }
        }
        return ans;
    }

    void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        parent.put(root, p);
        int d = (root.left != null ? 1 : 0) + (root.right != null ? 1 : 0);
        degree.put(root, d);
        if (d == 0) {
            queue.add(root);
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }
}

